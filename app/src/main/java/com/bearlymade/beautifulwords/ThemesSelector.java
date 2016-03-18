package com.bearlymade.beautifulwords;

/**
 * Created by cweaver on 3/17/2016.
 */
public class ThemesSelector {

    private static int[][] themes = {
            {R.color.backgroundBorder1,
                R.color.backgroundMain1,
                R.color.buttonBorder1,
                R.color.buttonMain1,
                R.color.text1
            },
            {R.color.backgroundBorder2,
                    R.color.backgroundMain2,
                    R.color.buttonBorder2,
                    R.color.buttonMain2,
                    R.color.text2
            },
            {R.color.backgroundBorder3,
                    R.color.backgroundMain3,
                    R.color.buttonBorder3,
                    R.color.buttonMain3,
                    R.color.text3
            },
            {R.color.backgroundBorder4,
                    R.color.backgroundMain4,
                    R.color.buttonBorder4,
                    R.color.buttonMain4,
                    R.color.text4
            },
            {R.color.backgroundBorder5,
                    R.color.backgroundMain5,
                    R.color.buttonBorder5,
                    R.color.buttonMain5,
                    R.color.text5
            },
            {R.color.backgroundBorder6,
                    R.color.backgroundMain6,
                    R.color.buttonBorder6,
                    R.color.buttonMain6,
                    R.color.text6
            }
    };

    public static int[] getTheme(int themeId) {
        return themes[themeId];
    }

    public static int themeCount() {
        return themes.length;
    }
}
