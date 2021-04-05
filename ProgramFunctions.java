import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Created by pc on 4/3/2021.
 */
public class ProgramFunctions {

    private LinkedList<String> list ;

    public ProgramFunctions() {
        this.list = new LinkedList<>();
    }

    private void setList ()
    {
        list.add("Yemen");
        list.add("America");
        list.add("Japan");
    }

    private boolean checkNumber (String x)
    {
        int count = 0;
        char [] ch = x.toCharArray();

        for (int i = 0; i <ch.length ; i++) {
            if (ch[i] > 47 & ch [i] < 58)
            {
                count++;
            }
            else
                break;
        }

        if (count == ch.length)
            return true;
        else
            return false;
    }

    protected boolean checkString (String x)
    {
        int count = 0;
        char [] ch = x.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            if ( (ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122) )
            {
                count++;
            }
            else
                break;
        }

        if (count == ch.length)
            return true;
        else
            return false;
    }

    public boolean valid22 (String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;

        else return pat.matcher(email).matches();

    }

    protected boolean checkPasswordValidity (String x)
    {
        char [] ch = x.toCharArray();
        int cInt = 0 ;
        int cChar = 0 ;
        if (ch.length >= 9)
        {
            for (int i = 0; i <ch.length ; i++) {
                if (ch[i] >= 48 & ch [i] <= 57)
                {
                    cInt++;
                }
                else
                    cChar++;
            }

            if ( cInt != 0 && cChar != 0 )
                return true;
            else
                return false;
        }
        else
            return false;
    }

    protected boolean checkPhone (String x)
    {
        char [] ch = x.toCharArray();
        if (checkNumber(x))
            if ( ch.length >=7 && ch.length <= 15 )
            {
                return true;
            }
            else
                return false;
        else
            return false;
    }

    protected boolean checkTownName (String x)
    {
        int count = 0;
        int chCount = 0;
        char [] ch = x.toCharArray();

        for (int i = 0; i < ch.length ; i++) {
            if (ch[i] > 47 & ch [i] < 58)
                break;
            else
            {
                if ( (ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122) )
                {
                    count++;
                }
                else
                    chCount++;
            }
        }

        if ( (count == ch.length-1 && chCount == 1) || (count == ch.length && chCount == 0))
            return true;
        else
            return false;
    }

    protected boolean checkAge (int x)
    {
        if ( x >= 18 && x <= 120)
        {
            return true;
        }
        else
            return false;
    }

    protected boolean checkCountry(String country)
    {
        setList();
        if (checkTownName(country))
            if (list.contains(country))
                return true;

        return false;
    }
}
