package com.PersianChat;

import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getLogger().info("[PersianChat] : Enable");
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        String chatPersian = event.getMessage();
        char[] marr = chatPersian.toCharArray();
        List<String> arr = new ArrayList<>();
        
        if (marr.length > 0 && !checkWord(String.valueOf(marr[0]))) {
            return;
        }
        
        for (int i = marr.length; i > 0; i--) {
            arr.add(String.valueOf(marr[i - 1]));
        }
        
        for (int num = 0; num < arr.size(); num++) {
            if (num > 0 && !arr.get(num - 1).equals(" ")) {
                arr.set(num, getWord(arr.get(num)));
                continue;
            }
            if (arr.get(num).equals("ه")) {
                arr.set(num, "ﻪ");
            }
        }
        
        StringBuilder fstring = new StringBuilder();
        for (String s : arr) {
            fstring.append(s);
        }
        
        event.setMessage(fstring.toString());
    }

    public boolean checkWord(String word) {
        String[] pwords = {"ض", "ص", "ث", "ق", "ف", "غ", "ع", "ه", "خ", "ح", "ج", "چ", "پ", "ش", "س", "ی", "ب", "ل", "ا", "ت", "ن", "م", "ک", "گ", "ک", "گ", "ظ", "ط", "ز", "ر", "ذ", "د", "ئ", "و"};
        return Arrays.asList(pwords).contains(word);
    }

    public String getWord(String word) {
        if (checkWord(word)) {
            switch (word) {
                case "ض":
                    return "ﺿ";
                case "ص":
                    return "ﺻ";
                case "ث":
                    return "ﺛ";
                case "ق":
                    return "ﻗ";
                case "ف":
                    return "ﻓ";
                case "غ":
                    return "ﻏ";
                case "ع":
                    return "ﻋ";
                case "ه":
                    return "ﻫ";
                case "خ":
                    return "ﺧ";
                case "ح":
                    return "ﺣ";
                case "ج":
                    return "ﺟ";
                case "چ":
                    return "ﭼ";
                case "پ":
                    return "ﭘ";
                case "ش":
                    return "ﺷ";
                case "ب":
                    return "ﺑ";
                case "س":
                    return "ﺳ";
                case "ی":
                    return "ﯾ";
                case "ل":
                    return "ﻟ";
                case "ا":
                    return "ا";
                case "ت":
                    return "ﺗ";
                case "ن":
                    return "ﻧ";
                case "م":
                    return "ﻣ";
                case "ک":
                    return "ﻛ";
                case "گ":
                    return "ﮔ";
                case "ظ":
                    return "ظ";
                case "ط":
                    return "ط";
                case "ز":
                    return "ز";
                case "ئ":
                    return "ئ";
                default:
                    return word;
            }
        } else {
            return word;
        }
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("[PersianChat] : Disable");
    }
} 