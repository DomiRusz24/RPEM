package pl.alvion.rpem.rpessentials.rpplayer_dr.traits;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.rpplayer_dr.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer_dr.enums.PlayerHealthEnum;

public enum Traits {
    Gastrophase("Gastrofaza"),
    Smells("Smierdzi"),
    Childish("Dziecinny"),
    MusclesLikeRock("MiesnieJakSkaly"),
    Explosive("Wybuchowy"),
    LittleOverWeight("TrocheNadwaga"),
    Tattoo("Tatuaz"),
    GoodMetabolism("DobryMetabolizm"),
    Gambler("Hazardzista"),
    Unlucky("Pech"),
    Depression("Depresja"),
    LeftHanded("LewoReczny"),
    Trauma("Trauma"),
    HighPitchVoice("Piskliwy"),
    Blindness("Slepota"),
    ThickSkin("GrubaSkora"),
    TailMutation("MalyOgon"),
    Alcoholic("Alkocholik"),
    Overweight("Nadwaga"),
    Vegan("Wegan"),
    BrokenBone("ZlamanaKosc"),
    AmputatedLimb("AmputowanyCzlonek"),
    ProstheticLimb("ProstetycznyCzlonek"),
    HandSickness("NiedowladReki"),
    Lucky("Szczesciaz"),
    BlackEyesMutation("CzarneOczy"),
    JaggedTeeth("SzczerbateZeby"),
    LostTeeth("BrakZeba"),
    GoldTeeth("ZlotyZab"),
    BeautifulVoice("PieknieSpiewa"),
    Obese("DuzaNadwaga"),
    GillsMutation("Skrzela"),
    Bald("Lysy"),
    Meanders("Zakola"),
    EyeHeterochromia("Heterochromia"),
    Voiceless("NieMowa"),
    CatEyes("KocieOczy"),
    NoThumbs("BrakKciukow"),
    AbsenceOfEye("BrakOka"),
    Light("Lekki"),
    ThirdPerson("TrzeciaOsoba"),
    Leper("Tredowaty"),
    Talassophobia("Talassofobia"),
    Achluophobia("Achluofobia"),
    Pyrophobia("Pyrofobia"),
    Agliophobia("Agliofobia"),
    Ekuinophobia("Ekuinofobia"),
    Skelerophobia("Skelerofobia"),
    Batmophobia("Batmofobia"),
    Tanatophobia("Tanatofobia"),
    Agrizoophobia("Agrizoofobia"),
    Linophobia("Linofobia"),
    Deaf("Gluchy"),
    SingsBad("FalszujeSpiewajac");


    private String PolishIndex;

    Traits(String PolishIndex) {
        this.PolishIndex = PolishIndex;
    }

    public String getPolishIndex() {
        return this.PolishIndex;
    }


    public static void addPlayerTrait(Player player, Traits trait, int input1, int input2) {
        if(!RPPlayer.getRPPlayer(player).getPlayerTraits().contains(trait)) {
            RPPlayer.getRPPlayer(player).getPlayerTraits().add(trait);
        }
        switch (trait) {
            case Gastrophase:
                break;
            case Smells:
                break;
            case Childish:
                break;
            case MusclesLikeRock:
                break;
            case Explosive:
                break;
            case LittleOverWeight:
                PlayerHealthEnum.Moving.setPlayerStaticEfficiency(player, PlayerHealthEnum.Moving.getPlayerStaticEfficiency(player) - 10);
                PlayerHealthEnum.BloodFiltration.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodFiltration.getPlayerStaticEfficiency(player) - 10);
                PlayerHealthEnum.BloodPumping.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodPumping.getPlayerStaticEfficiency(player) - 10);
                break;
            case Tattoo:
                break;
            case GoodMetabolism:
                PlayerHealthEnum.Metabolism.setPlayerEfficiency(player, 150);
                break;
            case Gambler:
                break;
            case Unlucky:
                break;
            case Depression:
                break;
            case LeftHanded:
                break;
            case Trauma:
                break;
            case HighPitchVoice:
                break;
            case Blindness:
                PlayerHealthEnum.Sight.setPlayerStaticEfficiency(player, 0);
                break;
            case ThickSkin:
                break;
            case TailMutation:
                break;
            case Alcoholic:
                PlayerHealthEnum.Consciousness.setPlayerStaticEfficiency(player, PlayerHealthEnum.Consciousness.getPlayerStaticEfficiency(player) - 5);
                break;
            case Overweight:
                PlayerHealthEnum.Moving.setPlayerStaticEfficiency(player, PlayerHealthEnum.Moving.getPlayerStaticEfficiency(player) - 20);
                PlayerHealthEnum.BloodFiltration.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodFiltration.getPlayerStaticEfficiency(player) - 20);
                PlayerHealthEnum.BloodPumping.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodPumping.getPlayerStaticEfficiency(player) - 20);
                PlayerHealthEnum.Breathing.setPlayerStaticEfficiency(player, PlayerHealthEnum.Breathing.getPlayerStaticEfficiency(player) - 5);
                break;
            case Vegan:
                PlayerHealthEnum.BloodPumping.setPlayerEfficiency(player, 105);
                PlayerHealthEnum.Metabolism.setPlayerStaticEfficiency(player, PlayerHealthEnum.Metabolism.getPlayerStaticEfficiency(player) - 5);
                PlayerHealthEnum.BloodFiltration.setPlayerEfficiency(player, 105);
                break;
            case BrokenBone:
                // TODO: kiedy sie zmerguje
                break;
            case AmputatedLimb:
                // TODO: kiedy sie zmerguje
                break;
            case ProstheticLimb:
                // TODO: kiedy sie zmerguje
                break;
            case HandSickness:
                // TODO: Choroba niedowlad reki kiedy sie zmerguje
                break;
            case Lucky:
                break;
            case BlackEyesMutation:
                break;
            case JaggedTeeth:
                break;
            case LostTeeth:
                // TODO: Brak zebu efekt kiedy sie zmerguje
                break;
            case GoldTeeth:
                break;
            case BeautifulVoice:
                PlayerHealthEnum.Talking.setPlayerEfficiency(player, 120);
                break;
            case Obese:
                PlayerHealthEnum.Moving.setPlayerStaticEfficiency(player, PlayerHealthEnum.Moving.getPlayerStaticEfficiency(player) - 30);
                PlayerHealthEnum.BloodFiltration.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodFiltration.getPlayerStaticEfficiency(player) - 30);
                PlayerHealthEnum.BloodPumping.setPlayerStaticEfficiency(player, PlayerHealthEnum.BloodPumping.getPlayerStaticEfficiency(player) - 30);
                PlayerHealthEnum.Breathing.setPlayerStaticEfficiency(player, PlayerHealthEnum.Breathing.getPlayerStaticEfficiency(player) - 10);
                // TODO: Obese choroba kiedy sie zmerguje
                break;
            case GillsMutation:
                break;
            case Bald:
                break;
            case Meanders:
                break;
            case EyeHeterochromia:
                break;
            case Voiceless:
                PlayerHealthEnum.Talking.setPlayerStaticEfficiency(player, 0);
                break;
            case CatEyes:
                break;
            case NoThumbs:
                PlayerHealthEnum.Manipulation.setPlayerStaticEfficiency(player, PlayerHealthEnum.Manipulation.getPlayerStaticEfficiency(player) - 10);
                break;
            case AbsenceOfEye:
                PlayerHealthEnum.Hearing.setPlayerStaticEfficiency(player, 50);
                // TODO: Usuniecie oka kiedy sie zmerguje
                break;
            case Light:
                PlayerHealthEnum.Moving.setPlayerEfficiency(player, 110);
                break;
            case ThirdPerson:
                break;
            case Leper:
                break;
            case Talassophobia:
                break;
            case Achluophobia:
                break;
            case Pyrophobia:
                break;
            case Agliophobia:
                break;
            case Ekuinophobia:
                break;
            case Skelerophobia:
                break;
            case Batmophobia:
                break;
            case Tanatophobia:
                break;
            case Agrizoophobia:
                break;
            case Linophobia:
                break;
            case Deaf:
                PlayerHealthEnum.Hearing.setPlayerStaticEfficiency(player, 0);
                break;
            case SingsBad:
                PlayerHealthEnum.Talking.setPlayerStaticEfficiency(player, PlayerHealthEnum.Talking.getPlayerStaticEfficiency(player) - 5);
                break;
        }
    }
}
