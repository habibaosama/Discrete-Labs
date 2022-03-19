package testset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Myset {

    //we used hash map to store every set name with it's values
    static HashMap<String, ArrayList> sets = new HashMap<String, ArrayList>();

    //this function convert the string  the input set to arraylist
    public static ArrayList convertToArray(String str) {

        str = str.replaceAll("\\{|\\}", "");
        String[] s = str.split(",");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(s));

        return list;
    }


    /*in this function we call the convert function
     * check if it is a set if not remove duplicate
     *the checksubset  function and if it is subset we add the set and it's name to our hash map if not
     *we make user input the set again until he write a subset set then put in the hash map
     */

    public static void addSets(int i, String str, ArrayList Universe) {

        Scanner scan = new Scanner(System.in);
        ArrayList myset = convertToArray(str);
        removeRepition(myset);

        while (!(myset.size() == 1 && myset.get(0) == "") && !checkSubset(Universe, myset)) {
            System.out.println("!!!! This Set is not subset to the Universe !!!!");
            System.out.println("Enter set" + i);
            str = scan.nextLine();
            myset = convertToArray(str);
            removeRepition(myset);
        }

        String setName = "set" + i;
        sets.put(setName, myset);

    }

    /*
     * this function to remove duplication from the set as it one of the set properties
     * */

    public static void removeRepition(ArrayList myset) {

        for (int k = 0; k < myset.size() - 1; k++) {
            for (int t = k + 1; t < myset.size(); t++) {
                if (myset.get(k).equals(myset.get(t))) {
                    myset.remove(t);
                    t = t - 1;
                }
            }
        }

    }


    /***union function
     * @param string  name of first set
     * @param string name of second set2
     * and by using their name we get array list from hash map
     *we add  all the both sets in op array list and then remove the duplicate
     *@return the op array list
     **/

    public ArrayList<String> Union(String set1, String set2) {

        ArrayList a = sets.get(set1);
        ArrayList b = sets.get(set2);
        ArrayList<String> op = new ArrayList<>();
        if (!(a.size() == 1 && a.get(0) == "")) {
            op.addAll(a);
        }
        if (!(b.size() == 1 && b.get(0) == "")) {
            op.addAll(b);
        }


        for (int i = 0; i < op.size() - 1; i++) {
            for (int j = i + 1; j < op.size(); j++) {
                if (op.get(i).equals(op.get(j))) {
                    op.remove(j);

                }
            }
        }

        return op;
    }


    /***intersection function
     * @param string  name of first set
     * @param string  name of second set2
     * and by using their name we get array list from hash map
     *we add  all the both sets in op array list and the duplicate put in array list oop
     *@return the oop array list
     **/

    public ArrayList<String> Intersection(String set1, String set2) {

        ArrayList a = sets.get(set1);
        ArrayList b = sets.get(set2);
        ArrayList<String> op = new ArrayList<>();
        ArrayList<String> opp = new ArrayList<>();
        op.addAll(a);
        op.addAll(b);

        for (int i = 0; i < op.size() - 1; i++) {
            for (int j = i + 1; j < op.size(); j++) {
                if (op.get(i).equals(op.get(j))) {
                    opp.add(op.get(i));

                }
            }
        }

        return opp;
    }

    /***complement function
     * @param string  name of first set which is the universe
     * @param string  name of set
     * and by using their name we get array list from hash map
     *we add  all the both sets in op array list and then remove the intersection
     *@return the op array list
     **/

    public ArrayList<String> Complement(ArrayList a, String set2) {

        ArrayList b = sets.get(set2);
        ArrayList<String> op = new ArrayList<>();
        op.addAll(a);

        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < op.size(); j++) {
                if (op.get(j).equals(b.get(i))) {
                    op.remove(j);
                }
            }
        }

        return op;
    }

    /*
     * this function check if the set is subset to the universe or not
     * by checking if the values present in universe then the flag assign to true
     * */

    public static boolean checkSubset(ArrayList universe, ArrayList set) {

        boolean flag = false;

        if (set.size() >= universe.size()) {
            return false;
        }


        for (int i = 0; i < set.size(); i++) {
            flag = false;
            for (int j = 0; j < universe.size(); j++) {
                if (((String) set.get(i)).equals((String) universe.get(j))) {
                    flag = true;
                }
            }

            if (flag == false) {
                return false;
            }
        }

        return true;

    }


    public ArrayList printset(String set) {
        return sets.get(set);

    }

}