package aea.bt.cryptography.Database;

import android.provider.BaseColumns;

public class Question {
    public class tableQuestion implements BaseColumns
    {
        public static final String questionTable_Name = "QuizTable";
        public static final String question = "Question";
        public static final String rightAnswer = "RightAnswer";
        public static final String option1 = "Option1";
        public static final String option2 = "option2";
        public static final String codeName = "codeName";
        }
    public class tableEditQuestion implements BaseColumns
    {
        public static final String questionEditTable_Name = "EditQuizTable";
        public static final String editQuestion = "EditQuestion";
        public static final String editRightAnswer = "EditRightAnswer";
        public static final String editCodeName = "EditCodeName";
    }
    public class tableQuestion1 implements BaseColumns
    {
        public static final String questionTable_Name = "QuizTable";
        public static final String question = "Question";
        public static final String rightAnswer = "RightAnswer";
        public static final String option1 = "Option1";
        public static final String option2 = "option2";
        public static final String codeName = "codeName";
    }
    }

