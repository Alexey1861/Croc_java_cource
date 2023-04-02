package System;

import Transports.*;

import java.util.Arrays;
import java.util.GregorianCalendar;


public final class AccountSystem {
    /** Массив с зарегистрированным транспортом */
    private SystemTransport[] allTransports;

    /**
     * Конструктор класса
     */
    public AccountSystem() {
        this.allTransports = new SystemTransport[0];
    }

    /**
     * Регисрация нового траноспорта в системе
     * @param transport Регистрируемый транспорт
     * @param category Категория транспорта
     */
    public void registerNewTransport(Transport transport, Category category) {
        SystemTransport newTransport = new SystemTransport(transport, category);
        this.allTransports = push(this.allTransports, newTransport);

        String message = String.format("\n%s успешно зарегистрирован\n", transport);
        System.out.println(message);
    }

    /**
     * Списани енеисправного транспорта
     * @param id id списываемого транспорта
     */
    public void disposeTransport(int id) {
        for (int i = 0; i < this.allTransports.length; i++) {
            SystemTransport bufTransport = this.allTransports[i];
            if (bufTransport.getId() == id) {
                if (!bufTransport.getIsServiceable()) {
                    this.allTransports = pop(this.allTransports, i);

                    String message = String.format("\n%s успешно списан\n", bufTransport.getTransport());
                    System.out.println(message);
                } else {
                    String message = String.format(
                            "\nОШИБКА: %s исправен и не требует списания\n",
                            bufTransport.getTransport()
                    );
                    System.out.println(message);
                }
                return;
            }
        }

        String message = String.format("\nОШИБКА: Транспорта с id %s не существует\n", id);
        System.out.println(message);
    }

    /**
     * Метод, дающий траспорт в аренду
     * @param id id транспорта
     * @param beginDate Дата начала аренды
     * @param endDate Дата конца аренды
     * @param person Имя арендующего
     * @return Транспорт если он сущесвует, иначе null
     */
    public Transport toRent(int id, GregorianCalendar beginDate, GregorianCalendar endDate, String person) {
        for (SystemTransport systemTransport : this.allTransports) {
            if (systemTransport.getId() == id) {
                if (systemTransport.getRent() == null) {
                    systemTransport.setRent(beginDate, endDate, person);

                    String message = String.format("\n%s успешно арендовал %s\n", person, systemTransport.getTransport());
                    System.out.println(message);

                    return systemTransport.getTransport();
                } else {
                    String message = String.format("\nОШИБКА: %s уже арендован\n", systemTransport.getTransport());
                    System.out.println(message);

                    return null;
                }
            }
        }

        String message = String.format("ОШИБКА: Транспорта с id %s не существует", id);
        System.out.println(message);

        return null;
    }

    /**
     * Метод принять обратно арендованного транспорта в нормальном состоянии
     * @param transport Арендованный транспорт
     */
    public void toAcceptRentedTransport(Transport transport) {
        for (SystemTransport systemTransport : this.allTransports) {
            if (systemTransport.getTransport().getId() == transport.getId()) {
                systemTransport.setRentByNull();

                String message = String.format("\nТранспорт %s успешно возвращён в нормальном состоянии\n", transport);
                System.out.println(message);

                return;
            }
        }

        String message = String.format("\nОШИБКА: Траспорта %s не сущесвует в системе\n", transport);
        System.out.println(transport);
    }

    /**
     * Метод принять обратно арендованного транспорта с указанием состояния
     * @param transport Арендованный транспорт
     * @param isServiceable Состояние транспорта
     */
    public void toAcceptRentedTransport(Transport transport, boolean isServiceable) {
        for (SystemTransport systemTransport : this.allTransports) {
            if (systemTransport.getTransport().getId() == transport.getId()) {
                systemTransport.setRentByNull();
                systemTransport.setIsServiceable(isServiceable);

                if (isServiceable) {
                    String message = String.format("\nТранспорт %s успешно возвращён в нормальном состоянии\n", transport);
                    System.out.println(message);
                } else {
                    String message = String.format("\nТранспорт %s успешно возвращён в неисправном состоянии\n", transport);
                    System.out.println(message);
                }

                return;
            }
        }

        String message = String.format("\nОШИБКА: Траспорта %s не сущесвует в системе\n", transport);
        System.out.println(transport);
    }

    /**
     * Узнать свободно ли тс по id в определённый период
     * @param id id транспорта
     * @param beginDate Нужная дата
     * @return true если свободно, false если несвободно
     */
    public boolean transportIsFree(int id, GregorianCalendar beginDate, GregorianCalendar endDate) {
        for (SystemTransport systemTransport : this.allTransports) {
            if (systemTransport.getId() == id) {
                if (systemTransport.getRent() != null) {
                    return true;
                } else {
                    GregorianCalendar systemBeginDate = systemTransport.getRent().getBeginDate();
                    GregorianCalendar systemEndDate = systemTransport.getRent().getEndDate();

                    if (endDate.before(systemBeginDate) || beginDate.after(systemEndDate)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        String message = String.format("\nОШИБКА: Транспорта с id %s не существует\n", id);
        System.out.println(message);

        return false;
    }

    /**
     * Узнать список свобных тс на апределённуюдата по определённой категории
     * @param needDate Нужня дата
     * @param category Категория
     * @return Массив свободного транспорта
     */
    public Transport[] findFreeTransportsByCategoryOnDate(GregorianCalendar needDate, Category category) {
        Transport[] freeTransports = new Transport[0];

        for (SystemTransport systemTransport : this.allTransports) {
            if (systemTransport.getCategory() == category) {
                if (systemTransport.getRent() == null) {
                    freeTransports = push(freeTransports, systemTransport.getTransport());
                } else {
                    GregorianCalendar systemBeginDate = systemTransport.getRent().getBeginDate();
                    GregorianCalendar systemEndDate = systemTransport.getRent().getEndDate();

                    if (needDate.before(systemBeginDate) || needDate.after(systemEndDate)) {
                        freeTransports = push(freeTransports, systemTransport.getTransport());
                    }
                }
            }
        }

        return freeTransports;
    }

    /**
     * Получить статистику по всему транспорту
     * @param beginDate Дата начала периода
     * @param endDate Дата конца периода
     */
    public void getStatistics(GregorianCalendar beginDate, GregorianCalendar endDate) {
        SystemTransport[] carsMas = new SystemTransport[0];
        SystemTransport[] trucksMas = new SystemTransport[0];
        SystemTransport[] planesMas = new SystemTransport[0];
        SystemTransport[] helicoptersMas = new SystemTransport[0];
        SystemTransport[] electricScootersMas = new SystemTransport[0];
        SystemTransport[] monowheelsMas = new SystemTransport[0];

        for (SystemTransport systemTransport : this.allTransports) {
            Transport transport = systemTransport.getTransport();
            if (transport.getClass().getName().equals("Transports.Car")) {
                carsMas = push(carsMas, systemTransport);
            } else if (transport.getClass().getName().equals("Transports.Truck")) {
                trucksMas = push(trucksMas, systemTransport);
            } else if (transport.getClass().getName().equals("Transport.Plane")) {
                planesMas = push(planesMas, systemTransport);
            } else if (transport.getClass().getName().equals("Transport.Helicopter")) {
                helicoptersMas = push(helicoptersMas, systemTransport);
            } else if (transport.getClass().getName().equals("Transports.ElectricScooter")) {
                electricScootersMas = push(electricScootersMas, systemTransport);
            } else if (transport.getClass().getName().equals("Transports.Monowheel")) {
                monowheelsMas = push(monowheelsMas, systemTransport);
            }
        }

        System.out.println(Category.AUTO);

        int freeCarsAmount = amountOfFreeTransports(carsMas, beginDate, endDate);
        String carsMessage = String.format(
                "    Автомобиль: Всего: %s; Свободных: %s",
                carsMas.length, freeCarsAmount
        );
        System.out.println(carsMessage);

        int freeTrucksAmount = amountOfFreeTransports(trucksMas, beginDate, endDate);
        String trucksMessage = String.format(
                "    Грузовик: Всего: %s; Свободных: %s",
                trucksMas.length, freeTrucksAmount
        );
        System.out.println(trucksMessage);

        System.out.println(Category.FLYING_AUTO);

        int freePlanesAmount = amountOfFreeTransports(planesMas, beginDate, endDate);
        String planesMessage = String.format(
                "    Самолёт: Всего: %s; Свободных: %s",
                planesMas.length, freePlanesAmount
        );
        System.out.println(planesMessage);

        int freeHelicoptersAmount = amountOfFreeTransports(helicoptersMas, beginDate, endDate);
        String helicoptersMessage = String.format(
                "    Вертолёт: Всего: %s; Свободных: %s",
                helicoptersMas.length, freeHelicoptersAmount
        );
        System.out.println(helicoptersMessage);

        System.out.println(Category.MOBILE_AUTO);

        int freeElectricScooterAmount = amountOfFreeTransports(electricScootersMas, beginDate, endDate);
        String electricScootersMessage = String.format(
                "    Электросамокат: Всего: %s; Свободных: %s",
                electricScootersMas.length, freeElectricScooterAmount
        );
        System.out.println(electricScootersMessage);

        int freeMonowheelsAmount = amountOfFreeTransports(monowheelsMas, beginDate, endDate);
        String monowheelsMessage = String.format(
                "    Моноколесо: Всего: %s; Свободных: %s",
                monowheelsMas.length, freeMonowheelsAmount
        );
        System.out.println(monowheelsMessage);
    }

    /**
     * Вспомогтаельный метод, реализующий подсчёт свободного транспорта в массиве за период
     * @param mas Массив, в котором нужно подсчитать количество
     * @param beginDate Дата начала периода
     * @param endDate Дата конца периода
     * @return Количесвто свободный тс
     */
    private int amountOfFreeTransports(SystemTransport[] mas, GregorianCalendar beginDate, GregorianCalendar endDate) {
        int count = 0;
        for (SystemTransport transport : mas) {
            if (transport.getRent() == null) {
                count++;
            } else {
                GregorianCalendar systemBeginDate = transport.getRent().getBeginDate();
                GregorianCalendar systemEndDate = transport.getRent().getEndDate();

                if (beginDate.after(systemEndDate) || endDate.before(systemBeginDate)) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Вспомогательный метод, реализующий добавление элемента в массив
     * @param mas Исходный массив
     * @param newValue Новый элемент
     * @return Обновл1нный массив
     * @param <T>
     */
    private <T> T[] push(T[] mas, T newValue) {
        T[] newMas = Arrays.copyOf(mas, mas.length + 1);
        newMas[newMas.length - 1] = newValue;

        return newMas;
    }

    /**
     * Вспомогательный метод, реализующий удаления элемента из массива по заданному индексу
     * @param mas Исходный массив
     * @param index Индекс элемента, который нужно удалить
     * @return Обновлённый массив
     * @param <T>
     */
    private <T> T[] pop(T[] mas, int index) {
        T[] newMas = mas.clone();
        for (int i = index; i < newMas.length - 1; i++) {
            newMas[i] = newMas[i + 1];
        }

        newMas = Arrays.copyOf(newMas, newMas.length - 1);

        return newMas;
    }
}
