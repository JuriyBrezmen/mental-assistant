package brezmen.yurii.mentalassistant.data.source;

import java.util.ArrayList;
import java.util.List;

import brezmen.yurii.mentalassistant.data.model.Disorder;
import brezmen.yurii.mentalassistant.data.model.Symptom;

/**
 * Created by yuriy on 21.04.17.
 */
public class Database {
    private static final int VISUAL_HALLUCINATIONS = 1; // зорові галюцинації
    private static final int EMOTIONS_CHANGING = 2; // зміна емоційних станів
    private static final int DELIRIUM = 3; // марення
    private static final int AUDITORY_HALLUCINATIONS = 4; // слухові галюцинації
    private static final int INFANTILE = 5;  // дитинячість
    private static final int TOMFOOLERY = 6; // дуркуватість
    private static final int APATHY = 7; // апатія
    private static final int WEAKNESS = 8; // млявість (фізична слабкість)
    private static final int PESSIMISM = 9; // песимізм
    private static final int BAD_MOOD = 10; // поганий настрій
    private static final int LOW_SELFeSTEEM = 11; // низька самооцінка
    private static final int BEDILITATION = 12; // виснаження
    private static final int HELPLESSNESS = 13; //  безпомічсність
    private static final int IRRITABILITY = 14; // дратівливість
    private static final int RETICENCE = 15; // мовчазність
    private static final int QUITL = 16; // почуття провини
    private static final int KINDLING = 17; // збудження
    private static final int EUPHORIA = 18; // ейфорія
    private static final int ANGUISH = 19; // туга
    private static final int EXALTATION = 20; // піднесення
    private static final int PROBLEMS_APPETITE = 21; // втрата апетиту
    private static final int AMNESIA = 22; // амнезія
    private static final int PARALYSIS = 23; // параліч
    private static final int FRISKINESS = 24; // грайливість, пустотливість
    private static final int VOMITING = 25; // блювання
    private static final int NYSTAGMUS = 26; // ністагм
    private static final int MURMUR = 27; // бурмотіння
    private static final int PROBLEMS_MEMORY = 28; // проблеми з пам'яттю
    private static final int PROBLEMS_LOGICAL = 29; // проблеми з логічним мисленням
    private static final int REDUCED_SENSITIVITY = 30; // понижена чутливість
    private static final int TINGLING = 31; // поколювання
    private static final int PROBLEM_COORDINATION = 32; // проблеми з координацією рухів
    private static final int BYSPNEA = 33; // задишка
    private static final int TACHICARDIA = 34; // тахікардія
    private static final int DISORIENTATION = 35; // дезорієнтація
    private static final int PARAMNESIA = 36; // парамнезія
    private static final int PROBLEMS_ORIENTATION_TIME = 37; // проблеми з орієнтацією в часі
    private static final int KRYPTOMNESIA = 38; // криптомнезія
    private static final int FIXATION_AMNESIA = 39; // фіксаційна амнезія
    private static final int MENTAL_RETARDATION = 40;// розумова відсталість
    private static final int DEMENTIA = 41;// слабоумство
    private static final int LOW_INTELLIGENCE = 42; // низький рівень інтелекту
    private static final int LOW_MENTALITY = 43;// низький рівень психіки
    private static final int UNSOCIAL_BEHAVIOR = 44;// соціально неприйнятна поведінка
    private static final int JEALOUSY = 45; // ревнощі
    private static final int PERSECUTION_MANIA = 46; // манія переслідування
    private static final int DECREASED_PERFORMANSCE = 47; // зниження працездатності
    private static final int LOW_LEARNING = 48; // зниження рівня навчання
    private static final int WITHOUT_WORLDINTERESTING = 49; // зниження рівня інтересу до навколишнього світу
    private static final int OLFACTORY_HALLUCINATIONS = 50; // нюхові галюцинації
    private static final int TACTILE_HALLUCINATIONS = 51; // тактильні галюцинації
    private static final int BODILY_HALLUCINATIONS = 52; // органічні галюцинації
    private static final int CATATINIA_STUPOR = 53; // кататонічний ступор
    private static final int CATALEPSY = 54; // воскова гручкість (каталепсія)
    private static final int STEREOTYPE = 55; // стереотипія
    private static final int ECHOLALIA = 56; // ехолалія
    private static final int ECHOPRAXIA = 57;// ехопраксія
    private static final int NEGATIVISM = 58;  // негативізм
    private static final int AMBIVALENCE = 59; // амбівалентність
    private static final int MUTISM = 60; // мутизм
    private static final int HIGHT_INTELLIGENCE = 61; // високий рівень інтелекту
    private static final int WITHOUT_UNDESTENDING_PERSONAL_MISTAKES = 62; // нездатність бачили власні помилки

    private List<Symptom> symptomList;
    private List<Disorder> disorderList;

    public Database() {
        symptomList = new ArrayList<>();
        disorderList = new ArrayList<>();

        createSymptomList();
        createDisorderList();
    }

    public List<Disorder> getDisorderList() {
        return disorderList;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    private Symptom createSymptom(int id, String name, String question, String description) {
        Symptom symptom = new Symptom();
        symptom.setId(id);
        symptom.setName(name);
        symptom.setQuestion(question);
        symptom.setDescription(description);
        return symptom;
    }

    private Disorder createDisorder(int id, String name, String description, Integer... symptoms) {
        Disorder disorder = new Disorder();
        disorder.setId(id);
        disorder.setName(name);
        disorder.setDescription(description);
        disorder.addSymptoms(symptoms);
        return disorder;
    }

    private void createSymptomList() {
        symptomList.add(createSymptom(VISUAL_HALLUCINATIONS,
                "Зорові галюцинації",
                "Чи присутні зорові галюцинації у хворого?",
                "У хворого викривлене  візуальне сприйняття зовнішнього світу, наприклад присутність об'єктів, " +
                        "істост та явищ, яких насправді немає.")
        );

        symptomList.add(createSymptom(EMOTIONS_CHANGING,
                "Зміна емоційних станів",
                "Чи спостерігається у хворого зміна емоційних станів?",
                "")
        );

        symptomList.add(createSymptom(DELIRIUM,
                "Марення",
                "У хворого бувають марення?",
                "")
        );

        symptomList.add(createSymptom(AUDITORY_HALLUCINATIONS,
                "Слухові галюцинації",
                "Чи присутні слухові галюцинації у хворого?",
                "")
        );

        symptomList.add(createSymptom(INFANTILE,
                "Дитячість",
                "Поведінка хворого схожа до поведінки дитини?",
                "")
        );

        symptomList.add(createSymptom(TOMFOOLERY,
                "Дуркуватість",
                "У хворого присутня дуркуватість?",
                "")
        );

        symptomList.add(createSymptom(APATHY,
                "Апатія",
                "Чи є прояви апатії?",
                "")
        );

        symptomList.add(createSymptom(WEAKNESS,
                "Млявість",
                "Чи присутня млявість під час рухів?",
                "")
        );

        symptomList.add(createSymptom(PESSIMISM,
                "Песимізм",
                "У хворого спостерігаються прояви песимізму?",
                "")
        );

        symptomList.add(createSymptom(FRISKINESS,
                "Грайливість",
                "Хворий поводиться пустотливо та грайливо?",
                "")
        );

        symptomList.add(createSymptom(BAD_MOOD,
                "Поганий настрій",
                "Чи часто хворий знаходиться у поганому настрої?",
                "")
        );

        symptomList.add(createSymptom(LOW_SELFeSTEEM,
                "Низька самооцінка",
                "У хворого низька самооцінка?",
                "")
        );

        symptomList.add(createSymptom(BEDILITATION,
                "Виснаження",
                "У хворого присутнє фізичне чи емоційне виснаження?",
                "")
        );

        symptomList.add(createSymptom(HELPLESSNESS,
                "Безпомічність",
                "Хворий почувається безпомічним?",
                "")
        );

        symptomList.add(createSymptom(IRRITABILITY,
                "Дратівливість",
                "Чи підвищена дратівливість?",
                "")
        );

        symptomList.add(createSymptom(RETICENCE,
                "Мовчазність",
                "Дана людина мовчазна?",
                "")
        );

        symptomList.add(createSymptom(QUITL,
                "Почуття провини",
                "Чи присутнє у хворого почуття провини?",
                "")
        );

        symptomList.add(createSymptom(KINDLING,
                "Збудження",
                "Чи проявляється у хворого загальне збудження?",
                "")
        );

        symptomList.add(createSymptom(EUPHORIA,
                "Ейфорія",
                "У хворого буває відчуття ейфорії?",
                "")
        );

        symptomList.add(createSymptom(ANGUISH,
                "Туга",
                "У хворого буває відчуття туги?",
                "")
        );

        symptomList.add(createSymptom(EXALTATION,
                "Піднесення",
                "У хворого буває піднесений настрій?",
                "")
        );

        symptomList.add(createSymptom(PROBLEMS_APPETITE,
                "Втрата апетиту",
                "Чи спостерігається втрата апетиту?",
                "")
        );

        symptomList.add(createSymptom(PARALYSIS,
                "Параліч",
                "Чи страждає хворий на параліч?",
                "")
        );

        symptomList.add(createSymptom(MURMUR,
                "Бурмотіння",
                "Чи присутнє порушення мови у вигляді бурмотіння?",
                "")
        );

        symptomList.add(createSymptom(PROBLEMS_MEMORY,
                "Проблеми з пам'яттю",
                "Чи бувають проблеми з пам'яттю?",
                "")
        );

        symptomList.add(createSymptom(PROBLEMS_LOGICAL,
                "Проблеми з логічним мисленням",
                "У хворого порушене логічне мислення? ",
                "")
        );

        symptomList.add(createSymptom(REDUCED_SENSITIVITY,
                "Понижена чутливість",
                "У хворого понижена чутливість?",
                "")
        );

        symptomList.add(createSymptom(TINGLING,
                "Поколювання",
                "Чи бувають у хворого поколювання у різних частинах тіла?",
                "")
        );

        symptomList.add(createSymptom(PROBLEM_COORDINATION,
                "Проблеми з координацією рухів",
                "Чи виникають складнощі з координацією рухів?",
                "")
        );

        symptomList.add(createSymptom(BYSPNEA,
                "Задишка",
                "У хворого буває задишка?",
                "")
        );

        symptomList.add(createSymptom(TACHICARDIA,
                "Тахікардія",
                "Хворий страждає на тахікардію?",
                "")
        );

        symptomList.add(createSymptom(DISORIENTATION,
                "Дизорієнтація",
                "Чи виникають проблеми із орієнтацією у просторі?",
                "")
        );

        symptomList.add(createSymptom(PARAMNESIA,
                "Парамнезія",
                "Чи виникають у хворого хибні або ж перекручені спогади, що інколи супроводжуються зміщенням у часі?",
                "")
        );

        symptomList.add(createSymptom(PROBLEMS_ORIENTATION_TIME,
                "Проблеми з орієнтацією в часі",
                "Чи виникають проблеми із орієнтуванням у часі?",
                "")
        );

        symptomList.add(createSymptom(KRYPTOMNESIA,
                "Криптомнезія",
                "Чи бувають у хворого проблеми із визначенням джерела раніше отриманої інформації?",
                "")
        );

        symptomList.add(createSymptom(FIXATION_AMNESIA,
                "Фіксаційна амнезія",
                "Чи виникають у хворого проблеми із запам'ятовуванням подій, що відбуваються у реальному часі?",
                "")
        );

        symptomList.add(createSymptom(MENTAL_RETARDATION,
                "Розумова відсталість",
                "Чи спостерігається розумова відсталість у хворого?",
                "")
        );

        symptomList.add(createSymptom(DEMENTIA,
                "Слабоумство",
                "Чи страждає на слабоумство?",
                "")
        );

        symptomList.add(createSymptom(LOW_INTELLIGENCE,
                "Низький рівень інтелекту",
                "У хворого низький рівень інтелекту?",
                "")
        );

        symptomList.add(createSymptom(LOW_MENTALITY,
                "Низький рівень психічного розвитку",
                "У хворого низький рівень психічного розвитку?",
                "")
        );

        symptomList.add(createSymptom(UNSOCIAL_BEHAVIOR,
                "Соціально неприйнятна поведінка",
                "Чи буває у хворого соціально неприйнятна поведінка?",
                "")
        );

        symptomList.add(createSymptom(JEALOUSY,
                "Ревнощі",
                "Чи відчуває хворий відчуття ревнощів?",
                "")
        );

        symptomList.add(createSymptom(PERSECUTION_MANIA,
                "Манія переслідування",
                "Хворий страждає на манію переслідування?",
                "")
        );

        symptomList.add(createSymptom(DECREASED_PERFORMANSCE,
                "Зниження рівня працездатності",
                "Чи спостерігається зниження рівня працездатності?",
                "")
        );

        symptomList.add(createSymptom(LOW_LEARNING,
                "Зниження здатності навчатись",
                "Чи спостерігається зниження здатності до навчання?",
                "")
        );

        symptomList.add(createSymptom(WITHOUT_WORLDINTERESTING,
                "Відсутність інтересу до довколишнього світу",
                "Хворий поводиться так, ніби його не цікавить довколишній світ?",
                "")
        );

        symptomList.add(createSymptom(OLFACTORY_HALLUCINATIONS,
                "Нюхові галюцинації",
                "Чи присутні нюхові галюцинації у хворого?",
                "")
        );

        symptomList.add(createSymptom(TACTILE_HALLUCINATIONS,
                "Тактильні галюцинації",
                "Чи присутні тактильні галюцинації у хворого?",
                "")
        );

        symptomList.add(createSymptom(BODILY_HALLUCINATIONS,
                "Органічні галюцинації",
                "Хворий жаліється на проблеми із внутрішніми органами?",
                "")
        );

        symptomList.add(createSymptom(CATATINIA_STUPOR,
                "Кататонічний ступор",
                "Чи застигає хворий у одній позі протягом тривалого часу?",
                "")
        );

        symptomList.add(createSymptom(CATALEPSY,
                "Каталепсія",
                "Чи зберігає хворий пози, механічно надані його тілу?",
                "")
        );

        symptomList.add(createSymptom(STEREOTYPE,
                "Стереотипія",
                "Чи спостерігаються моготонні розхитування чи інші одноманітні рухи?",
                "")
        );

        symptomList.add(createSymptom(ECHOLALIA,
                "Ехолалія",
                "Чи повторює хворий слова, які він чує?",
                "")
        );

        symptomList.add(createSymptom(ECHOPRAXIA,
                "Ехопраксія",
                "Хворий повторює побачені дії?",
                "")
        );

        symptomList.add(createSymptom(NEGATIVISM,
                "Негативізм",
                "Хворий робить протилежне тому, чого від нього вимагають?",
                "")
        );

        symptomList.add(createSymptom(AMBIVALENCE,
                "Амбівалентність",
                "Чи спостерігаєть ставлення до когось чи до чогось одночасно позитивно і негативно?",
                "")
        );

        symptomList.add(createSymptom(MUTISM,
                "Мутизм",
                "У хворого спостерігався стан, коли він не відповідав на запитання чи навіть знаками не давав" +
                        " зрозуміти, що він згоден вступити в контакт з оточуючими?",
                "")
        );

        symptomList.add(createSymptom(HIGHT_INTELLIGENCE,
                "Високий рівень інтелекту",
                "Спостерігається високий рівень інтелекту?",
                "")
        );

        symptomList.add(createSymptom(WITHOUT_UNDESTENDING_PERSONAL_MISTAKES,
                "Нездатність бачити власні помилки",
                "Хворий здатний помічати та усвідомлювати власні помилки та проблеми?",
                "")
        );
    }

    private void createDisorderList() {
        disorderList.add(createDisorder(1,
                "Параноя",
                "Опис параної",
                VISUAL_HALLUCINATIONS, EMOTIONS_CHANGING, DELIRIUM, UNSOCIAL_BEHAVIOR, JEALOUSY,
                PERSECUTION_MANIA)
        );

        disorderList.add(createDisorder(2,
                "Проста шизофренія",
                "Опис простої шизофренії",
                VISUAL_HALLUCINATIONS, AUDITORY_HALLUCINATIONS, DECREASED_PERFORMANSCE, LOW_LEARNING,
                WITHOUT_WORLDINTERESTING, OLFACTORY_HALLUCINATIONS, TACTILE_HALLUCINATIONS, BODILY_HALLUCINATIONS)
        );

        disorderList.add(createDisorder(3,
                "Гебефренічна шизофренія",
                "Опис Гебефренічної шизофренії",
                INFANTILE, TOMFOOLERY, FRISKINESS)
        );

        disorderList.add(createDisorder(4,
                "Депресія",
                "Опис депресії",
                BAD_MOOD, LOW_SELFeSTEEM, PESSIMISM, APATHY, WEAKNESS, HELPLESSNESS, IRRITABILITY,
                RETICENCE, QUITL)
        );

        disorderList.add(createDisorder(5,
                "Біполярний афективний розлад",
                "Опис біполярного афективного розладу",
                EUPHORIA, KINDLING, EXALTATION, ANGUISH)
        );

        disorderList.add(createDisorder(6,
                "Циклотимія",
                "Опис циклотимії",
                KINDLING, EUPHORIA, EMOTIONS_CHANGING, EXALTATION, ANGUISH)
        );

        disorderList.add(createDisorder(7,
                "Синдром Корсакова",
                "Опис синдрому Корсакова",
                AMNESIA, PROBLEMS_ORIENTATION_TIME, DISORIENTATION, PARALYSIS, FIXATION_AMNESIA,
                KRYPTOMNESIA)
        );

        disorderList.add(createDisorder(8,
                "Кататонічна шизофренія",
                "Опис кататонічної шизофренії",
                CATATINIA_STUPOR, STEREOTYPE, CATALEPSY, ECHOLALIA, ECHOPRAXIA, NEGATIVISM,
                AMBIVALENCE, MUTISM)
        );

        disorderList.add(createDisorder(9,
                "Параноїдальна шизофренія",
                "Опис параноїдальної шизофренії",
                HIGHT_INTELLIGENCE, WITHOUT_UNDESTENDING_PERSONAL_MISTAKES, PERSECUTION_MANIA, UNSOCIAL_BEHAVIOR)
        );

    }

}
