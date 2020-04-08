package pl.alvion.rpem.rpessentials.rpplayer.traits;

import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;

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
    Leper("Tredowaty");

    private String PolishIndex;

    Traits(String PolishIndex) {
        this.PolishIndex = PolishIndex;
    }

    public String getPolishIndex() {
        return this.PolishIndex;
    }

    public static void playerTrait(Player player, Traits trait , int input1, int input2) {
        if(RPPlayer.getRPPlayer(player).getPlayerTraits() != null) {
            boolean firstTime = !RPPlayer.getRPPlayer(player).getPlayerTraits().contains(trait);
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

                    break;
                case Tattoo:

                    break;
                case GoodMetabolism:

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

                    break;
                case ThickSkin:

                    break;
                case TailMutation:

                    break;
                case Alcoholic:

                    break;
                case Overweight:

                    break;
                case Vegan:

                    break;
                case BrokenBone:

                    break;
                case AmputatedLimb:

                    break;
                case ProstheticLimb:

                    break;
                case Lucky:

                    break;
                case BlackEyesMutation:

                    break;
                case JaggedTeeth:

                    break;
                case LostTeeth:

                    break;
                case GoldTeeth:

                    break;
                case HandSickness:

                    break;
                case BeautifulVoice:

                    break;
                case Obese:

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

                    break;
                case CatEyes:

                    break;
                case NoThumbs:

                    break;
                case AbsenceOfEye:

                    break;
                case Light:

                    break;
                case ThirdPerson:

                    break;
                case Leper:

                    break;
            }
    }





}
