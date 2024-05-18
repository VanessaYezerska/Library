package library.javabot.bgd;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


@Component
public class LibraryBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
       return "library_ldubgd_bot";
    }

    @Override
    public String getBotToken() {
        return "5957300741:AAGg2Gvdb2lDJWTPG6Zu5Ibq3r3oWRBZHEo";
    }

    @Override
    public void onUpdateReceived(Update update) {Message message = update.getMessage();
        System.out.println("Повідомлення від користувача: " + message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Будь ласка, оберіть потрібний варіант:");
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.getText().equals("/start")) {
            String text = "Вітаю! Це бібліотека ЛДУ БЖД. Тут Ви можете знайти рекомендовані книги для Вашої спеціальності.\n";
            text = text + "Оберіть потрібний варіант :)\n";

            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getBooksKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);
            sendMessage.setText(text);

        }
        else if (message.getText().equals("Навчально-науковий інститут цивільного захисту")) {
            // Отримано команду "Інститут цивільного захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForCivilProtection();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }else if (message.getText().equals("Навчально-науковий інститут психології та соціального захисту")) {
            // Отримано команду "Інститут психології та соціального захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForPsychologyAndSocialProtection();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }else if (message.getText().equals("Навчально-науковий інститут пожежної та техногенної безпеки")) {
            // Отримано команду "Інститут психології та соціального захисту", змінюємо клавіатуру
            ReplyKeyboardMarkup newKeyboardMarkup = getNewKeyboardForFireAndTechnogenicSafety();
            sendMessage.setReplyMarkup(newKeyboardMarkup);
        }


        if (message.getText().equals("Назад")){
            String a = "Оберіть потрібний варіант:";
            ReplyKeyboardMarkup keyboardMarkup = getBooksKeyboard();
            sendMessage.setText(a);
            sendMessage.setReplyMarkup(keyboardMarkup);
        }
        if (message.getText().equals("Кібербезпека")) {
            String books = "Книги для студентів спеціальності кібербезпека:\n\n";
            books = books + "1. Назва: Математичні основи криптографії\nАвтор: Стасюк Марта\nРік видання:2015\n\n";
            books = books + "2. Системи баз даних та знань, Берко А.Ю., Верес О.М., Пасічник В.В., 2019\n\n";
            books = books + "3. Програмне та алгоритмічне забезпечення сховищ та просторів даних, Шаховська Н.Б., 2010\n\n";
            books = books + "4. Системи штучного інтелекту, Шаховська Н.Б., Камінський Р.М., Вовк О.Б., 2018\n\n";
            books = books + "5. Ось таким, як мені кажуть, буде кінець світу: перегони кіберозброєнь, Перлрос Н., 2022\n\n";
            books = books + "6. Штучний інтелект і безпека, Юрій Когут, 2024\n\n";
            books = books + "7. Дипломатія: кібербезпека та шляхетність переговорів, П.М. Лісовський, Ю.П. Лісовська, 2021\n\n";
            books = books + "8. Технології блокчейн та криптовалюта: ризики та кібербезпека, Юрій Когут, 2022\n\n";
            books = books + "9. Гібридна війна нового типу як загроза національній безпеці держав, Юрій Когут, 2023\n\n";
            books = books + "10. Суперінтелект. Стратегії і небезпеки розвитку розумних машин, Нік Бостром, 2020\n\n";
            books = books + "11. Кібервійни, кібертероризм, кіберзлочинність. Концепції, стратегії, технології, Юрій Когут, 2022\n\n";
            books = books + "12. Машина, платформа, натовп. Як приборкати наше цифрове майбутнє, Ендрю Макафі, Ерік Брінйольфссон, 2023\n\n";
            books = books + "13. Посібник The Financial Times зi стратегiї для соцiальних медiа, Мартін Томас, 2020\n\n";
            books = books + "14. Досконала зброя. Війна, саботаж і страх у кіберепоху, Девід Е. Сенґер, 2022\n\n";
            books = books + "15. Свобода в мережі. Як насправді працює інтернет, Уліґ У. , Кнодель М., Нільс Тен Евер, Корін Кат, 2023\n\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Комп'ютерні науки")) {
            String books = "Книги для студентів спеціальності комп'ютерні науки:\n\n";
            books = books + "1. Основи програмування (Python, Java), Смотр О., Придатко О., Малець І., 2019\n\n";
            books = books + "2. Сучасні інформаційні засоби навчання, Гороль П.К., Гуревич Р.С., Коношевський Л.Л., Шестопалюк О.В., 2008\n\n";
            books = books + "3. Інформаційно-телекомунікаційні технології в навчальному процесі та наукових дослідженнях, Гуревич Р.С., Кадемія М.Ю., 2006\n\n";
            books = books + "4. Інформаційно-телекомунікаційні технології в професійній освіті майбутніх фахівців, Гуревич Р.С., Кадемія М.Ю., Козяр М.М., 2012\n\n";
            books = books + "5. Інформаційна технологія раннього виявлення лісових пожеж за допомогою безпілотних літальних апаратів, Гусак О.М., 2018\n\n";
            books = books + "6. Моделі та механізми формування портфеля наукових проектів вищого навчального закладу на основі системно-ціннісного підходу, Драч І.Є., 2014\n\n";
            books = books + "7. Когнітивні моделі формування стратегій оперативного управління інтегрованими ієрархічними структурами в умовах ризиків і конфліктів, Дурняк Б.В., Сікора Л.С., Антоник М.С., Ткачук Р.Л., 2013\n\n";
            books = books + "8. Автоматизовані людино-машинні системи управління інтегрованими ієрархічними організаційними та виробничими структурами в умовах ризику і конфліктів, Дурняк Б.В., Сікора Л.С., Антоник М.С., Ткачук Р.Л., 2013\n\n";
            books = books + "9. Інформаційні та лазерні технології відбору потоків даних та їх когнітивна інтерпретація в автоматизованих системах управління, Дурняк Б.В., Сікора Л.С., Лиса Н.К., Ткачук Р.Л., Яворський Б.І.,2017\n\n";
            books = books + "10. Обгрунтування регіональних портфелів проектів удосконалення безпеки життєдіяльності, Зачко О.Б., 2009\n\n";
            books = books + "11. Системні засоби управління безпекою в ІТ-проектах, Зачко О.Б., Рак Ю.П., 2015\n\n";
            books = books + "12. Організаційно-педагогічні умови формування професійної компетентності курсантів засобами інформаційно-комунікаційних технологій, Ткаченко Т.В., 2009\n\n";
            books = books + "13. Моделі та методи управління програмою освітніх проектів підготовки рятувальників, Придатко О.В.,2014\n\n";
            books = books + "14. Проектно-організаційне управління офісом системи цивільного захисту для підвищення безпеки життєдіяльності, Квашук В.П., 2014\n\n";
            books = books + "15. Якість програмного забезпечення та тестування, Білас О., 2011\n\n";

            sendMessage.setText(books);
        }
        if (message.getText().equals("Екологія")) {
            String books = "Книги для студентів спеціальності екологія:\n\n";
            books = books + "1. Екосередовище і сучасність, Дорогунцов С.І., Хвесик М.А., Горбач Л.М., Пастушенко П.П.,2007\n";
            books = books + "2. Екологічна економіка,Мельник А.Г.,2006\n";
            books = books + "3. Економіка природних ресурсів,Мельник А.Г., Сотник І.М., Чигрин О.Ю.,2010\n";
            books = books + "4. Загальна екологія. Практичний курс,Руденко С.С., Костишин С.С., Морозова Т.В.,2008\n";
            books = books + "5. Філософія екологічної освіти сталого розвитку,Філіпчук Г.Г.,2012\n";
            books = books + "6. Промислова екологія,Апостолюк С.О., Джигирей В.С., Соколовський І.А., Сомар Г.В., Лук'янчук Н.Г.,2012\n";
            books = books + "7. Екологія людини,Гончаренко М.С., Бойчук Ю.Д.,2005\n";
            books = books + "8. Екологія довкілля. Охорона природи,Грицик В., Канарський Ю., Бедрій Я.,2009\n";
            books = books + "9. Екологія автомобільного транспорту,Гутаревич Ю.Ф., Зеркалов Д.В., Говорун А.Г.,2002\n";
            books = books + "10. Ландшафтна екологія,Давиденко В.А., Білявський Г.О., Арсенюк С.Ю.,2007\n";
            books = books + "11. Екологія та охорона навколишнього природного середовища,Джигирей В.С.,2007\n";
            books = books + "12. Загальна екологія,Злобін Ю. А. , Кочубей Н. В.,2003\n";
            books = books + "13. Екологія міських систем,Клименко М.О., Пилипенко Ю.В., Мороз О.С.,2010\n";
            books = books + "14. Екологія,Кучерявий В.П.,2001\n";
            books = books + "15. Екологія,Кучерявий В.П.,2001\n";
            sendMessage.setText(books);
        }
        if (message.getText().equals("Цивільна безпека")) {
            String books = "Книги для студентів спеціальності цивільна безпека:\n";
            books = books + "1. Основи управління в органах і підрозділах МНС України,Альбощій О.В., Кулєшов М.М., Калашніков О.О., Рашкевич С.А., Труш О.О.,2007\n";
            books = books + "2. Цивільна оборона України,Бедрій Я.І., Івах Р.М., Рощин В.О., Ємкало В.М.,2011\n";
            books = books + "3. Профілювання місії державної цільової соціальної програми цивільного захисту,Босак В.В.,2011\n";
            books = books + "4. Основи цивільного захисту,Васійчук В.О., Гончарук В.Є., Качан С.І., Мохняк С.М.,2010\n";
            books = books + "5. Основи підготовки пожежника,Дмитровський С.Ю., Лущ В.І., Семенюк П.В.,2011\n";
            books = books + "6. Управління та організація у сфері цивільного захисту,Зосімов В.П., Садковий В.П., Ушаков Л.В.,2006\n";
            books = books + "7. Проектно-організаційне управління офісом системи цивільного захисту для підвищення безпеки життєдіяльності,Квашук В.П.,2014\n";
            books = books + "8. Формування професійної готовності майбутніх рятувальників до діяльності в екстремальних умовах,Коваль І.С.,2017\n";
            books = books + "9. Практичний посібник з питань адміністративно - правової діяльності у сфері цивільного захисту населення і територій від надзвичайних ситуацій,Коваль М.С., Сукач Ю.Г., Колівошко С.Н., Половко А.П.,2006\n";
            books = books + "10. Безпека життєдіяльності та цивільний захист,Левченко О.Г., Землянська О.В., Праховнік Н.А., Зацарний В.В.,2019\n";
            books = books + "11. Моделі та методи управління програмою освітніх проектів підготовки рятувальників,Придатко О.В.,2014\n";
            books = books + "12. Розвиток державного управління у сфері професійної підготовки кадрів цивільного захисту:теорія, практика, механізм,Садковий В. П.,2014\n";
            books = books + "13. Організація служби і професійної підготовки в ДСНС України,Сукач Р.Ю., Лоїк В.Б.,2015\n";
            books = books + "14. Державне управління ризиками виникнення надзвичайних ситуацій,Федорчак В. В.,2018\n";
            books = books + "15. Адміністративно-правова діяльність у сфері цивільного захисту, техногенної та пожежної безпеки,Чалий Д.О., Сукач Ю.Г., Сукач Р.Ю., Гаврись А.П.,2021\n";

            sendMessage.setText(books);

        }if (message.getText().equals("Психологія")) {
            String books = "Книги для студентів спеціальності психологія:\n";
            books = books + "1. Юридична психологія,Александров Д.О., Андросюк В.Г., Казміренко Л.І. ,2007\n";
            books = books + "2. Психологія праці,Баклицький І.О.,2004\n";
            books = books + "3. Експериментальна психологія,Баклицький І.О., Сірко Р.І.,2011\n";
            books = books + "4. Психологія людини з обмежиними можливостями,Бочелюк В.Й., Турубарова А.В.,2011\n";
            books = books + "5. Соціальна психологія в рекламі,Бутенко Н.Ю.,2006\n";
            books = books + "6. Загальна психологія,Варій М.Й.,2007\n";
            books = books + "7. Психологія особистості,Варій М.Й.,2008\n";
            books = books + "8. Психологія,Варій М.Й.,2009\n";
            books = books + "9. Психологія спілкування,Вашека Т.В., Гічан І.С.,2006\n";
            books = books + "10. Соціальна психологія,Волянська О.В., Ніколаєвська А.М.,2008\n";
            books = books + "11. Соціальна психологія,Волянська О.В., Ніколаєвська А.М.,2008\n";
            books = books + "12. Психологія конфлікту,Долинська Л.В., Матяш-Заяц Л.П.,2010\n";
            books = books + "13. Дошкільна психологія,Дуткевич Т.В.,2007\n";
            books = books + "14. Психологія мотивації,Занюк С.С.,2002\n";
            books = books + "15. Психологія конфлікту,Долинська Л.В., Матяш-Заяц Л.П.,2010\n";

            sendMessage.setText(books);

        }if (message.getText().equals("Менеджмент")) {
            String books = "Книги для студентів спеціальності менеджмент:\n";
            books = books + "1. Менеджмент 3.0. AGILE-менеджмент. Лідерство та управління командами,Аппело Юрген,2019\n";
            books = books + "2. Операційний менеджмент,Балаш Л., Лисюк О., Саміло А., Ковальчук О.,2023\n";
            books = books + "3. Екологічний менеджмент,Бобровський А.Л.,2009\n";
            books = books + "4. Кризовий менеджмент та принципи управління ризиками в процесі ліквідації медико-санітарних наслідків надзвичайних ситуацій,Гур’єв С.О.,Терент’єва А.В., Волянський П.Б.,2008\n";
            books = books + "5. Основи підприємництва (опорний конспект лекцій) для здобувачів вищої овіти денноїта заочної форми навчання за спеціальністю 073 Менеджмент,Дубинецька П.П., Содома Р.І., Саміло А.В.,2022\n";
            books = books + "6. Безжальний менеджмент та ефективність людських ресурсів,Кеннеді Ден,2019\n";
            books = books + "7. Грунти України: властивості, генезис, менеджмент родючості,Купичк В.І., Іваніна В.В., Нестеров Г.І.,2011\n";
            books = books + "8. Податковий менеджмент,Купчак М.Я., Саміло А.В.,2020\n";
            books = books + "9. Менеджмент соціальної роботи: Теорія і практика,Лукашевич М.П., Туленков М.В.,2020\n";
            books = books + "10. Менеджмент персоналу,Мурашко М.І.,2008\n";
            books = books + "11. AGILE продукт-менеджмент за допомогою Scrum: створення продуктів, що подобаються клієнтам,Піхлер Роман,2019\n";
            books = books + "12. Екологічний менеджмент у поводженні із побутовими відходами на регіональному рівні: прогнозування екологічної ситуації,Попович В.В.,2021\n";
            books = books + "13. Логістика: теорія та практика,Кислий В.М., Біловодська О.А., Олефіренко О.М.,Смоляник О.М.,2020\n";
            books = books + "14. Логістика та управління ланцюгами поставок,Крикавський Є., Похильченко О., Фертч М.,2020\n";
            books = books + "15. Транспортна логістика,Смирнов І.Г., Косарева Т.В.,2008\n";

            sendMessage.setText(books);
        }if (message.getText().equals("Пожежна безпека")) {
            String books = "Книги для студентів спеціальності Пожежна безпека:\n";
            books = books + "1. Охорона праці.Пожежна безпека,Білінський Б.О., Гаврилко О.А., Козяр Н.М., Пістун І.П., Стець Р.Є.,Фірман В.М., Юзьків Т.Б., Яремко З.М.,2012\n";
            books = books + "2. Пожежна небезпека колісних транспортних засобів,Гаврилюк А.Ф.,2018\n";
            books = books + "3. Пожежна охорона Івано-Франківщини від минулого до сучасності,Антонюк Р., Яремчук В.,2004\n";
            books = books + "4. Пожежна безпека на залізничному транспорті,Доманський В.А., Зеркалов Д.В., Потетюєв С.Ю., Лінчевський Є.А., Дорошенко М.В.,2004\n";
            books = books + "5. Пожежна тактика,Клюс П.П.,1998\n";
            books = books + "6. Пожежна охорона Рівненщини. Історія і сьогодення,Костюк М. В.,2004\n";
            books = books + "7. Пожежна безпека енергетичних підприємств,Косюк В.В.,2012\n";
            books = books + "8. Пожежна безпека будівель та споруд,Кулєшов М.М. ,2004\n";
            books = books + "9. Пожежна безпека як складова національної безпеки: економічні аспекти,Мартин О.М.,2017\n";
            books = books + "10. Пожежна служба Закарпаття: Минуле і сучасне,Нитка В.І.,2009\n";
            books = books + "11. Пожежна та техногенна безпека основних небезпечних виробництв,Павлюк Ю.Е., Бабаджанова О.Ф.,2008\n";
            books = books + "12. Пожежна тактика. Курс лекцій,Пархоменко Р.В., Чалий Д.О., Войтович Д.П.,2017\n";
            books = books + "13. Пожежна безпека об’єктів агропромислового комплексу,Пелешко М.З. ,2010\n";
            books = books + "14. Пожежна охорона Львівщини (1772-1939),Попович С.,1999\n";
            books = books + "15. Пожежна безпека,Рожков А.П,1999\n";

            sendMessage.setText(books);
        }if (message.getText().equals("Транспортні технології")) {
            String books = "Книги для студентів спеціальності транспортні технології:\n";
            books = books + "1. Транспортні навантажувально-розвантажувальні засоби,Вікович І.А.,2018\n";
            books = books + "2. Автомобільні транспортні засоби. Основи конструкції,Підгородецький Я.І.,Сичевський М.І., Домінік А.М.,2013\n";
            books = books + "3. Автомобільні транспортні засоби. Основи конструкції,Підгородецький Я.І.,Сичевський М.І., Домінік А.М.,2018\n";
            books = books + "4. Транспортні засоби,Сичевський М.І., Ренкас А.Г., Придатко О.В.,2011\n";
            books = books + "5. Екологія та автомобільний транспорт,Гутаревич Ю.Ф., Зеркалов Д.В., Говорун А.Г. ,2008\n";
            books = books + "6. Соціальна та демографічна статистика (збірник задач для виконання на семінарських заняттях та самостійної роботи),Грицанюк В.В.,2015\n";
            books = books + "7. Теплотворення й теплоспоживання в двигуні швидкого внутрішнього згоряння, Гащук П., С. Нікіпчук ,2021\n";
            books = books + "8. Управління автомобільним транспортом, Левковець П.,  Зеркалов Д.,  Мельниченко О.,  Казаченко О.,2008\n";
            books = books + "9. Транспорт і шляхи сполучення, Савенко В., Гайдукевич В.,2007\n";
            books = books + "10. Транспортна екологія. Навчальний посібник,О. Запорожець ,2017\n";
            books = books + "11. Охорона праці в галузі. Організаційно-технічні аспекти. Посібник для підготовки фахівців ОС Магістр спеціальності Транспортні технології (автомобільний транспорт), Войналович О.,  Голопура С.,2020\n";
            books = books + "12. Екологістика, рециклінг і утилізація транспорту. Навчальний посібник, Яковлева А., Бойченко С.,  Лейда К., Іванченко О., Фролов В.,2019 \n";
            books = books + "13. Матеріали та матеріалознавство в автомобільному транспорті, Косенко В., Кущевська Н.,2015\n";
            books = books + "14. Філософія безпечного керування автомобілем, Шаповал В., Малишев В., Залюбовський М.,2020\n";
            books = books + "15. Машини та обладнання підприємства,Малишев В., Залюбовський М.,2020\n";

            sendMessage.setText(books);
        }if (message.getText().equals("Соціальна робота")) {
            String books = "Книги для студентів спеціальності соціальна робота:\n";
            books = books + "1. Соціальна робота в громаді,Безпалько О.В.,2005\n";
            books = books + "2. Соціальна робота на підприємстві,Васильєв В.В.,2011\n";
            books = books + "3. Соціальна робота,Гайдук Н.М.,2007\n";
            books = books + "4. Вступ до спеціальності Соціальна робота,Карпенко О.Г.,2011\n";
            books = books + "5. Соціальна робота,Капська А.Й.,2011\n";
            books = books + "6. Соціальна робота (теорія і практика),Лукашевич М.П., Семигіна Т.В.,2018\n";
            books = books + "7. Соціальна робота: теорія і практика,Тюптя Л.Т., Іванова І.Б.,2008\n";
            books = books + "8. Соціальна робота: теорія і практика,Тюптя Л.Т., Іванова І.Б.,2014\n";
            books = books + "9. Методи соціальної роботи (на основі Державних стандартів соціальних послуг), Іванова І.,2018\n";
            books = books + "10. Соціальна робота з різними категоріями клієнтів,Белавін С.П. ,2007\n";
            books = books + "11. Соціальна робота: методика викладання. Навчально-методичний посібник, Іванова І., Л. Тюптя,2011 \n";
            books = books + "12. Актуальні питання соціальної роботи,Епель О.В.,2023\n";
            books = books + "13. Соціальна робота з вимушеними переселенцями в сучасній Україні. Монографія,Нікітіна В.,Борисова О., Знаткова О., Кульга О. ,2019\n";
            books = books + "14. Менеджмент соціальної роботи,Лукашевич М.П., Туленков М.В.,2023\n";
            books = books + "15. Соціальна педагогіка,Безпалько О. В.,2014\n";

            sendMessage.setText(books);
        }if (message.getText().equals("Філологія")) {
            String books = "Книги для студентів спеціальності філологія:\n";
            books = books + "1. Англійська мова для ад'юнктів пожежо-технічних спеціальностей,Іванів О.В., Шуневич В.І.,2012\n";
            books = books + "2. Англійська мова професійного спрямування. Безпека руху та обслуговування автомобіля,Іванченко М.Ю.,2019\n";
            books = books + "3. Професійна англійська мова : тести і вправи,Бадюк О.О., Вовчаста Н.Я., Дідух Л.І., Іванів О.В., Ткаченко Т.В., Шванова О.В.,2011\n";
            books = books + "4. Англійська мова для рятувальників  ,Вовчаста Н.Я., Дідух Л.І.,2011\n";
            books = books + "5. Англійська мова для екологів,Вовчаста Н.Я., Дідух Л.І., Шванова О.В.,2011\n";
            books = books + "6. Англійська мова для фахівців у сфері транспортних технологій,Дробіт І.М., Маслюк Д.М.,2014\n";
            books = books + "7. Англійська мова для психологів,Кухарська В.Б.,2007\n";
            books = books + "8. Business English. Ділова англійська мова,Маланюк М.С.,2018\n";
            books = books + "9. Англійська мова для повсякденного спілкування,Шпак В.К.,2001\n";
            books = books + "10. Англійська мова для студентів технічних вузів,Ятель Г.П.,1993\n";
            books = books + "11. Основи культури і техніки мовлення,Климова К.Я,2007\n";
            books = books + "12. Етика ділового та повсякденного спілкування,Кубрак О.В.,2005\n";
            books = books + "13. Культура міжособистісної комунікації,Кульчицька М.О.,2013\n";
            books = books + "14. Еристика,Хоменко І.В.,2008\n";
            books = books + "15. Ділове спілкування,Хміль Ф.І.,2004\n";

            sendMessage.setText(books);
        }




        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }


    private ReplyKeyboardMarkup getNewKeyboardForFireAndTechnogenicSafety() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Менеджмент");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Пожежна безпека");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Транспортні технології");
        keyboardRows.add(keyboardRow3);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getNewKeyboardForPsychologyAndSocialProtection() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Психологія");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Соціальна робота");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Філологія");
        keyboardRows.add(keyboardRow3);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
    private ReplyKeyboardMarkup getNewKeyboardForCivilProtection() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Комп'ютерні науки");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Кібербезпека");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Екологія");
        keyboardRows.add(keyboardRow3);

        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add("Цивільна безпека");
        keyboardRows.add(keyboardRow4);

        KeyboardRow backRow = new KeyboardRow();
        backRow.add("Назад");
        keyboardRows.add(backRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }


    private ReplyKeyboardMarkup getBooksKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add("Навчально-науковий інститут цивільного захисту");
        keyboardRows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("Навчально-науковий інститут психології та соціального захисту");
        keyboardRows.add(keyboardRow2);

        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add("Навчально-науковий інститут пожежної та техногенної безпеки");
        keyboardRows.add(keyboardRow3);


        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }



}
