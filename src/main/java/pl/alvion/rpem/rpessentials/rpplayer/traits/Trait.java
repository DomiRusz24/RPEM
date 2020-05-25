package pl.alvion.rpem.rpessentials.rpplayer.traits;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.alvion.rpem.rpessentials.RPEssentials;
import pl.alvion.rpem.rpessentials.rpplayer.RPPlayer;
import pl.alvion.rpem.rpessentials.rpplayer.stats.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public enum Trait {
    Gastrophase(ChatColor.RED + "Gastrofaza", 2),
    Smells(ChatColor.WHITE + "Smierdzi", 4),
    Childish(ChatColor.WHITE + "Dziecinny", 2),
    MusclesLikeRock(ChatColor.GREEN + "Miesnie jak skaly", 2),
    Explosive(ChatColor.WHITE + "Wybuchowy", 2),
    LittleOverWeight(ChatColor.RED + "Troche nadwaga", 4),
    Tattoo(ChatColor.WHITE + "Tatuaz", 4),
    GoodMetabolism(ChatColor.GREEN + "Dobry metabolizm", 3),
    Gambler(ChatColor.WHITE + "Hazardzista", 4),
    Unlucky(ChatColor.RED + "Pech", 2),
    Depression(ChatColor.WHITE + "Depresja", 2),
    LeftHanded(ChatColor.WHITE + "Leworeczny", 2),
    Trauma(ChatColor.WHITE + "Trauma", 1),
    HighPitchVoice(ChatColor.WHITE + "Piskliwy", 2),
    Blindness(ChatColor.RED + "Slepota", 1),
    ThickSkin(ChatColor.GREEN + "Gruba skora", 3),
    TailMutation(ChatColor.WHITE + "Mutacja - ogonek", 2),
    Alcoholic(ChatColor.WHITE + "Alkoholik", 4),
    Overweight(ChatColor.RED + "Nadwaga", 3),
    Vegan(ChatColor.WHITE + "Wegan", 1),
    AmputatedLimb(ChatColor.RED + "Amputowany czlonek/Proteza", 1),
    HandSickness(ChatColor.RED + "Niedowlad reki", 1),
    Lucky(ChatColor.GREEN + "Szczesciaz", 3),
    BlackEyesMutation(ChatColor.WHITE + "Biale oczy", 2),
    JaggedTeeth(ChatColor.WHITE + "Szczerbate zeby", 1),
    LostTeeth(ChatColor.WHITE + "Brak zeba", 1),
    GoldTeeth(ChatColor.WHITE + "Zloty zab", 1),
    BeautifulVoice(ChatColor.WHITE + "Pieknie spiewa", 2),
    Obese(ChatColor.RED + "Duza nadwaga", 2),
    GillsMutation(ChatColor.GREEN + "Skrzela", 1),
    Bald(ChatColor.WHITE + "Lysy/Zakola", 1),
    EyeHeterochromia(ChatColor.WHITE + "Heterochromia", 2),
    Voiceless(ChatColor.RED + "Niemowa", 1),
    CatEyes(ChatColor.GREEN + "Kocie oczy", 1),
    NoThumbs(ChatColor.RED + "Brak kciukow", 1),
    AbsenceOfEye(ChatColor.WHITE + "Brak oka", 2),
    Light(ChatColor.GREEN + "Lekki", 1),
    ThirdPerson(ChatColor.WHITE + "Trzecia osoba", 1),
    Leper(ChatColor.RED + "Tredowaty", 1),
    Talassophobia(ChatColor.RED + "Talassofobia", 1),
    Achluophobia(ChatColor.RED + "Achluofobia", 1),
    Pyrophobia(ChatColor.RED + "Pyrofobia", 2),
    Agliophobia(ChatColor.RED + "Agliofobia", 1),
    Ekuinophobia(ChatColor.RED + "Ekuinofobia", 2),
    Skelerophobia(ChatColor.RED + "Skelerofobia", 2),
    Batmophobia(ChatColor.RED + "Batmofobia", 1),
    Tanatophobia(ChatColor.RED + "Tanatofobia", 3),
    Agrizoophobia(ChatColor.RED + "Agrizoofobia", 2),
    Linophobia(ChatColor.RED + "Linofobia", 1),
    Deaf(ChatColor.RED + "Gluchy", 1),
    SingsBad(ChatColor.WHITE + "Falszuje spiewajac", 3);


    public static ArrayList<Trait> traitByChance = new ArrayList<>();

    public static void loadTraitsByChanceArray() {
        for (Trait trait : Trait.values()) {
            for (int i = trait.chance; i > 0; i--) {
                traitByChance.add(trait);
            }
        }
    }

    private String PolishIndex;
    private int chance;
    Trait(String PolishIndex) {
        this.PolishIndex = PolishIndex;
    }
    Trait(String PolishIndex, int chance) {
        this.PolishIndex = PolishIndex;
        this.chance = chance;
    }
    public String getPolishIndex() {
        return this.PolishIndex;
    }

    public static Trait getByPolishIndex(String name) {
        for (Trait trait : Trait.values()) {
            if (trait.PolishIndex.equalsIgnoreCase(name)) return trait;
        }
        return null;
    }

    public static Trait[] getRandomTraits(int count) {
        ArrayList<Integer> used = new ArrayList<>();
        Random random = new Random();
        Trait[] traits = new Trait[count];
        for (int i = 0; i < count;) {
            int r = random.nextInt(traitByChance.size());
            if (!used.contains(r)) {
                used.add(r);
                traits[i]= traitByChance.get(r);
                i++;
            }
        }
        return traits;
    }

    public static String traitsToString(ArrayList<Trait> traits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Trait trait : traits) {
            stringBuilder.append(trait.name()).append(",");
        }
        return stringBuilder.toString();
    }

    public static ArrayList<Trait> stringToTraits(String string) {
        ArrayList<Trait> traits = new ArrayList<>();
        for (String s : string.split(",")) {
            traits.add(valueOf(s));
        }
        return traits;
    }

    public void addTrait(Player player) {
        String path = "Player." + player.getName() + ".traits";
        if (RPEssentials.getRPPlayerDataConfig().get(path) == null) {
            RPEssentials.getRPPlayerDataConfig().set(path, this.name() + ",");
        }
        else {
            RPEssentials.getRPPlayerDataConfig().set(path, getRawTraits(player) + this.name() + ",");
        }
        RPEssentials.saveRPPlayerConfig();
    }

    public void removeTrait(Player player) {
        String path = "Player." + player.getName() + ".traits";
        if (RPEssentials.getRPPlayerDataConfig().get(path) == null) return;
        else {
            if (!getRawTraits(player).contains(this.name() + ",")) {
                RPEssentials.getRPPlayerDataConfig().set(path, getRawTraits(player).replaceAll(this.name() + ",", ""));
            }
        }
        RPEssentials.saveRPPlayerConfig();
    }

    public static String getRawTraits(Player player) {
        return RPEssentials.getRPPlayerDataConfig().getString("Player." + player.getName() + ".traits");
    }

    public static void addPlayerTrait(Player player, Trait trait, int input1, int input2) {
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
            case AmputatedLimb:
                break;
            case HandSickness:
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
            case BeautifulVoice:
                break;
            case Obese:
                break;
            case GillsMutation:
                break;
            case Bald:
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
                break;
            case SingsBad:
                break;
        }
    }
}
