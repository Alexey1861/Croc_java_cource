import java.time.LocalTime;
import java.util.Arrays;

/**
 * Класс описывающий парковку
 */
public class Parking {
    /** Общее количество мест */
    private int totalPlaces;
    /**Количество свободных мест*/
    private int freePlaces;
    /** Массив, содержащий въезды в парковку */
    private Enter[] enters;
    /** Массив, содержащий выезды в парковку */
    private Exit[] exits;
    /** Массив, содержащий неудачные попытки въездов в парковку */
    private Attempt[] badAttempts = new Attempt[0];

    /**
     * Конструтор класса
     * @param totalPlaces Общее количество мест
     * @param enters Массив въездов
     * @param exits Массив выездов
     */
    public Parking(int totalPlaces, Enter[] enters, Exit[] exits) {
        this.totalPlaces = totalPlaces;
        this.freePlaces = totalPlaces;
        this.enters = enters;
        this.exits = exits;
    }

    /**
     * Метод принимающий автомобиль на парковку
     * @param car Машина
     * @param enterNumber Номер въезда
     * @return Возвращает код ответа: 1 -- машина может заехать; 2 -- указанного въезда не существует; 3 -- мест нет
     */
    public int toAccept(Car car, int enterNumber) {
        if (this.freePlaces > 0) {
            Enter enter = getEnter(enterNumber);
            if (enter != null) {
                enter.useTheEnter(car);
                this.freePlaces--;
                return 1;
            } else {
                return 2;
            }
        } else {
            Attempt attempt = new Attempt(car.getNumber(), LocalTime.now());
            this.badAttempts = append(this.badAttempts, attempt);

            return 3;
        }
    }

    /**
     * Вспомогательный метод, находящий въезд с нужгым номером
     * @param enterNumber Номер въезда
     * @return Номер въезда, если находит, иначе -- null
     */
    private Enter getEnter(int enterNumber) {
        for (Enter enter : this.enters) {
            if (enterNumber == enter.getNumber()) {
                return enter;
            }
        }
        return null;
    }

    /**
     * Вспомогательный метод, который добавляет неудачную попытку в массив неудачных попыток
     * @param mas Массив неудачных попыток
     * @param attempt Неудачная попытка
     * @return Увеличенный массив
     */
    private Attempt[] append(Attempt[] mas, Attempt attempt) {
        Attempt[] newMas = Arrays.copyOf(mas, mas.length + 1);
        newMas[newMas.length - 1] = attempt;

        return newMas;
    }

    /**
     * Метод, выпускающий машину с парковки
     * @param car Выезжающая машина
     * @param exitNumber Номер выезда
     * @return true если выезд с данным номером существует, иначе -- false
     */
    public boolean toRelease(Car car, int exitNumber) {
        Exit exit = getExit(exitNumber);
        if (exit != null) {
            this.freePlaces++;
            exit.useTheExit(car);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Вспомогательный метод, находящий выезд с нужгым номером
     * @param exitNumber Номер въезда
     * @return Номер выезда, если находит, иначе -- null
     */
    private Exit getExit(int exitNumber) {
        for (Exit exit : this.exits) {
            if (exitNumber == exit.getNumber()) {
                return exit;
            }
        }
        return null;
    }

    /**
     * Метод, возвращающий информацию о наличии свободных мест на парковке
     * @return true, если свободные места есть, иначе -- false
     */
    public boolean canGoInto() {
        if (this.freePlaces > 0) {
            System.out.println("Автомобиль может заехать (свободные места есть)");
            return true;
        } else {
            System.out.println("Автомобиль не может заехать (свободных мест нет)");
            return false;
        }
    }

    /**
     * Геттер количества свободых мест
     * @return Количество свободных мест
     */
    public int getFreePlaces() {
        return this.freePlaces;
    }

    /**
     * Геттер массива с неудачными попытками
     * @return Массив  неудачными попытками
     */
    public Attempt[] getBadAttempts() {
        return this.badAttempts;
    }

    /**
     * Геттер массива с машинами проехавшими через въезд с данным номером
     * @param enterNum Номер въезда
     * @return Массив, если въезд с данным номером существует, иначе null
     */
    public Car[] getCarsListByEnter(int enterNum) {
        Enter enter = getEnter(enterNum);
        if (enter != null) {
            return enter.getCarsList();
        } else {
            return null;
        }
    }

    /**
     * Геттер массива с машинами проехавшими через выезд с данным номером
     * @param exitNum Номер выезда
     * @return Массив, если выезд с данным номером существует, иначе null
     */
    public Car[] getCarsListByExit(int exitNum) {
        Exit exit = getExit(exitNum);
        if (exit != null) {
            return exit.getCarsList();
        } else {
            return null;
        }
    }
}
