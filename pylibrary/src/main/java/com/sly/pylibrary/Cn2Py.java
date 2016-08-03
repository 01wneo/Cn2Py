package com.sly.pylibrary;

import java.util.Arrays;
import java.util.List;

/**
 * @author: HeyGays
 * @description: 在unicode字符集中，汉字的编码范围为4E00 到 9FA5 之间（即从第19968开始的20902个字符是中文简体字符）
 * 我们把这些字符的拼音首字母按照顺序都存放在一个char数组中。当我们查找一个汉字的拼音首字母时，
 * 只需把这个汉字的unicode码减去19968得到一个index，然后用这个数字作为索引去找集合中index的位置即可
 * @date: 2016-08-02
 * @time: 16:44
 */

public class Cn2Py {
    public static final int HANZI_START = 19968;//汉字开始位置
    public static final int HANZI_END = 40869;//结束位置
    public static final int HANZI_COUNT = 20902;//汉字总个数
    private static List<String> pyDicList;//字典集合

    /**
     * 加载拼音字典(全是小写)，该版本字典中所有生僻字拼音都是no
     */
    private static void readPyDicList() {
        StringBuffer pyDicStr = new StringBuffer();
        pyDicStr.append(PinYinDic.INDEX_24968)
                .append(PinYinDic.INDEX_29969)
                .append(PinYinDic.INDEX_34970)
                .append(PinYinDic.INDEX_39971)
                .append(PinYinDic.INDEX_40869);
        String[] pyStr = pyDicStr.toString().split(",");
        pyDicList = Arrays.asList(pyStr);
    }

    /**
     * 获取字符串第一个字符的首字母，常用于联系人索引
     *
     * @param name eg.老王
     * @return L
     */
    public static String getRootChar(String name) {
        if (pyDicList == null) {
            readPyDicList();
        }
        String indexChar = null;
        int uniCode = name.charAt(0);
        //a-z或者A-Z
        if ((uniCode >= 65 && uniCode <= 90) || (uniCode >= 97 && uniCode <= 122)) {
            indexChar = String.valueOf((char) uniCode);
        }
        //汉字
        else if (uniCode >= HANZI_START && uniCode <= HANZI_END) {
            indexChar = String.valueOf(pyDicList.get(uniCode - HANZI_START).charAt(0));//只获取首字母
        }
        //其它
        else {
            indexChar = "#";
        }
        //因为要用作在listview中间插入索引，所以要返回大写的字母
        return indexChar.toUpperCase();
    }

    /**
     * 获取汉字的首拼缩写,用'',"隔开
     *
     * @param name eg.老王
     * @return l, w,
     */
    public static String getIndexPinYin(String name) {
        if (pyDicList == null) {
            readPyDicList();
        }
        StringBuffer indexPinYin = new StringBuffer();
        for (int i = 0; i < name.length(); i++) {
            String n = name.substring(i, i + 1);
            indexPinYin.append(getRootChar(n) + ",");
        }
        return indexPinYin.toString().toLowerCase();//小写
    }

    /**
     * 获取汉字全拼,用","号隔开
     *
     * @param name eg.老王
     * @return lao, wang,
     */
    public static String getFullPinYin(String name) {
        if (pyDicList == null) {
            readPyDicList();
        }
        StringBuffer pinYinGroup = new StringBuffer();
        for (int i = 0; i < name.length(); i++) {
            String n = name.substring(i, i + 1);
            int uniCode = n.charAt(0);
            if (uniCode >= HANZI_START && uniCode <= HANZI_END) {
                String pinyin = String.valueOf(pyDicList.get(uniCode - HANZI_START));
                pinYinGroup.append(pinyin + ",");
            } else {
                pinYinGroup.append(n + ",");
            }
        }
        return pinYinGroup.toString();
    }
}
