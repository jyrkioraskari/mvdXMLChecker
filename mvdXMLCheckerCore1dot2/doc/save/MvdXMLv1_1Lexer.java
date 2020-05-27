// $ANTLR 3.4 E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g 2016-05-10 15:28:17

package nl.tue.ddss.mvdxml1dot1.rule_operators;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MvdXMLv1_1Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int AND=4;
    public static final int DIGIT=5;
    public static final int EQUAL=6;
    public static final int ESC_SEQ=7;
    public static final int FALSE=8;
    public static final int GREATER_THAN=9;
    public static final int GREATER_THAN_OR_EQUAL=10;
    public static final int HEX_DIGIT=11;
    public static final int INT=12;
    public static final int LESS_THAN=13;
    public static final int LESS_THAN_OR_EQUAL=14;
    public static final int LETTER=15;
    public static final int LPAREN=16;
    public static final int NOT_EQUAL=17;
    public static final int OCTAL_ESC=18;
    public static final int OR=19;
    public static final int RPAREN=20;
    public static final int SIMPLEID=21;
    public static final int SIZE=22;
    public static final int STRING=23;
    public static final int TRUE=24;
    public static final int TYPE=25;
    public static final int UNICODE_ESC=26;
    public static final int UNIQUE=27;
    public static final int UNKNOWN=28;
    public static final int VALUE=29;
    public static final int WS=30;
    public static final int XOR=31;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public MvdXMLv1_1Lexer() {} 
    public MvdXMLv1_1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MvdXMLv1_1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g"; }

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:6:7: ( '+' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:6:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:7:7: ( '-' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:7:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:8:7: ( '.' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:8:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:9:7: ( 'e' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:9:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:10:7: ( 'reg' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:10:9: 'reg'
            {
            match("reg"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:110:3: ( '[Value]' | '[value]' | '[VALUE]' )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='[') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='V') ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2=='a') ) {
                        alt1=1;
                    }
                    else if ( (LA1_2=='A') ) {
                        alt1=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA1_1=='v') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:110:5: '[Value]'
                    {
                    match("[Value]"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:110:17: '[value]'
                    {
                    match("[value]"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:110:29: '[VALUE]'
                    {
                    match("[VALUE]"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VALUE"

    // $ANTLR start "SIZE"
    public final void mSIZE() throws RecognitionException {
        try {
            int _type = SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:112:3: ( '[Size]' | '[size]' | '[SIZE]' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='[') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='S') ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2=='i') ) {
                        alt2=1;
                    }
                    else if ( (LA2_2=='I') ) {
                        alt2=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA2_1=='s') ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:112:5: '[Size]'
                    {
                    match("[Size]"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:112:16: '[size]'
                    {
                    match("[size]"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:112:27: '[SIZE]'
                    {
                    match("[SIZE]"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SIZE"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:114:3: ( '[Type]' | '[type]' | '[TYPE]' )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='[') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='T') ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2=='y') ) {
                        alt3=1;
                    }
                    else if ( (LA3_2=='Y') ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA3_1=='t') ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:114:5: '[Type]'
                    {
                    match("[Type]"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:114:16: '[type]'
                    {
                    match("[type]"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:114:27: '[TYPE]'
                    {
                    match("[TYPE]"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "UNIQUE"
    public final void mUNIQUE() throws RecognitionException {
        try {
            int _type = UNIQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:116:3: ( '[Unique]' | '[unique]' | '[UNIQUE]' )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='[') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='U') ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2=='n') ) {
                        alt4=1;
                    }
                    else if ( (LA4_2=='N') ) {
                        alt4=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA4_1=='u') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:116:5: '[Unique]'
                    {
                    match("[Unique]"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:116:18: '[unique]'
                    {
                    match("[unique]"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:116:31: '[UNIQUE]'
                    {
                    match("[UNIQUE]"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNIQUE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:2: ( 'AND' | 'and' | 'And' | '&' | ';' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 'A':
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='N') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='n') ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'a':
                {
                alt5=2;
                }
                break;
            case '&':
                {
                alt5=4;
                }
                break;
            case ';':
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:4: 'AND'
                    {
                    match("AND"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:12: 'and'
                    {
                    match("and"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:20: 'And'
                    {
                    match("And"); 



                    }
                    break;
                case 4 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:28: '&'
                    {
                    match('&'); 

                    }
                    break;
                case 5 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:118:34: ';'
                    {
                    match(';'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:120:2: ( 'OR' | 'or' | 'Or' | '|' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 'O':
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='R') ) {
                    alt6=1;
                }
                else if ( (LA6_1=='r') ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'o':
                {
                alt6=2;
                }
                break;
            case '|':
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:120:4: 'OR'
                    {
                    match("OR"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:120:11: 'or'
                    {
                    match("or"); 



                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:120:18: 'Or'
                    {
                    match("Or"); 



                    }
                    break;
                case 4 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:120:25: '|'
                    {
                    match('|'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:122:2: ( 'XOR' | 'xor' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='X') ) {
                alt7=1;
            }
            else if ( (LA7_0=='x') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:122:4: 'XOR'
                    {
                    match("XOR"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:122:12: 'xor'
                    {
                    match("xor"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:124:2: ( '=' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:124:4: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:126:2: ( '!=' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:126:4: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "GREATER_THAN"
    public final void mGREATER_THAN() throws RecognitionException {
        try {
            int _type = GREATER_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:128:2: ( '>' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:128:4: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATER_THAN"

    // $ANTLR start "GREATER_THAN_OR_EQUAL"
    public final void mGREATER_THAN_OR_EQUAL() throws RecognitionException {
        try {
            int _type = GREATER_THAN_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:130:2: ( '>=' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:130:4: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATER_THAN_OR_EQUAL"

    // $ANTLR start "LESS_THAN"
    public final void mLESS_THAN() throws RecognitionException {
        try {
            int _type = LESS_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:132:2: ( '<' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:132:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_THAN"

    // $ANTLR start "LESS_THAN_OR_EQUAL"
    public final void mLESS_THAN_OR_EQUAL() throws RecognitionException {
        try {
            int _type = LESS_THAN_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:134:2: ( '<=' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:134:4: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_THAN_OR_EQUAL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:136:2: ( 'FALSE' | 'false' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='F') ) {
                alt8=1;
            }
            else if ( (LA8_0=='f') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:136:4: 'FALSE'
                    {
                    match("FALSE"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:136:14: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:138:2: ( 'TRUE' | 'true' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='T') ) {
                alt9=1;
            }
            else if ( (LA9_0=='t') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:138:4: 'TRUE'
                    {
                    match("TRUE"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:138:13: 'true'
                    {
                    match("true"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "UNKNOWN"
    public final void mUNKNOWN() throws RecognitionException {
        try {
            int _type = UNKNOWN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:140:2: ( 'UNKNOWN' | 'unknown' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='U') ) {
                alt10=1;
            }
            else if ( (LA10_0=='u') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:140:4: 'UNKNOWN'
                    {
                    match("UNKNOWN"); 



                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:140:16: 'unknown'
                    {
                    match("unknown"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNKNOWN"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:142:2: ( '0' .. '9' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:144:2: ( ( '0' .. '9' )+ )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:144:4: ( '0' .. '9' )+
            {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:144:4: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            int _type = HEX_DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:146:2: ( DIGIT | ( 'a' .. 'f' | 'A' .. 'F' ) )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:148:2: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SIMPLEID"
    public final void mSIMPLEID() throws RecognitionException {
        try {
            int _type = SIMPLEID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:150:2: ( LETTER ( LETTER | DIGIT | '_' )* )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:150:4: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 


            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:150:11: ( LETTER | DIGIT | '_' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SIMPLEID"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:152:2: ( '(' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:152:7: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:154:2: ( ')' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:154:7: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            int _type = OCTAL_ESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:156:2: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1 >= '0' && LA13_1 <= '3')) ) {
                    int LA13_2 = input.LA(3);

                    if ( ((LA13_2 >= '0' && LA13_2 <= '7')) ) {
                        int LA13_4 = input.LA(4);

                        if ( ((LA13_4 >= '0' && LA13_4 <= '7')) ) {
                            alt13=1;
                        }
                        else {
                            alt13=2;
                        }
                    }
                    else {
                        alt13=3;
                    }
                }
                else if ( ((LA13_1 >= '4' && LA13_1 <= '7')) ) {
                    int LA13_3 = input.LA(3);

                    if ( ((LA13_3 >= '0' && LA13_3 <= '7')) ) {
                        alt13=2;
                    }
                    else {
                        alt13=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:156:7: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:156:51: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:156:84: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            int _type = UNICODE_ESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:158:2: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:158:7: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            int _type = ESC_SEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:160:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt14=1;
                    }
                    break;
                case 'u':
                    {
                    alt14=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt14=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:160:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:160:58: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:160:75: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:162:2: ( '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:162:6: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
            {
            match('\''); 

            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:162:11: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    alt15=1;
                }
                else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '&')||(LA15_0 >= '(' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:162:13: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:162:23: ~ ( '\\\\' | '\\'' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:164:2: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:164:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:164:4: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= '\t' && LA16_0 <= '\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:8: ( T__32 | T__33 | T__34 | T__35 | T__36 | VALUE | SIZE | TYPE | UNIQUE | AND | OR | XOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS )
        int alt17=33;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:10: T__32
                {
                mT__32(); 


                }
                break;
            case 2 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:16: T__33
                {
                mT__33(); 


                }
                break;
            case 3 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:22: T__34
                {
                mT__34(); 


                }
                break;
            case 4 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:28: T__35
                {
                mT__35(); 


                }
                break;
            case 5 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:34: T__36
                {
                mT__36(); 


                }
                break;
            case 6 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:40: VALUE
                {
                mVALUE(); 


                }
                break;
            case 7 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:46: SIZE
                {
                mSIZE(); 


                }
                break;
            case 8 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:51: TYPE
                {
                mTYPE(); 


                }
                break;
            case 9 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:56: UNIQUE
                {
                mUNIQUE(); 


                }
                break;
            case 10 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:63: AND
                {
                mAND(); 


                }
                break;
            case 11 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:67: OR
                {
                mOR(); 


                }
                break;
            case 12 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:70: XOR
                {
                mXOR(); 


                }
                break;
            case 13 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:74: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 14 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:80: NOT_EQUAL
                {
                mNOT_EQUAL(); 


                }
                break;
            case 15 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:90: GREATER_THAN
                {
                mGREATER_THAN(); 


                }
                break;
            case 16 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:103: GREATER_THAN_OR_EQUAL
                {
                mGREATER_THAN_OR_EQUAL(); 


                }
                break;
            case 17 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:125: LESS_THAN
                {
                mLESS_THAN(); 


                }
                break;
            case 18 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:135: LESS_THAN_OR_EQUAL
                {
                mLESS_THAN_OR_EQUAL(); 


                }
                break;
            case 19 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:154: FALSE
                {
                mFALSE(); 


                }
                break;
            case 20 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:160: TRUE
                {
                mTRUE(); 


                }
                break;
            case 21 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:165: UNKNOWN
                {
                mUNKNOWN(); 


                }
                break;
            case 22 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:173: DIGIT
                {
                mDIGIT(); 


                }
                break;
            case 23 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:179: INT
                {
                mINT(); 


                }
                break;
            case 24 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:183: HEX_DIGIT
                {
                mHEX_DIGIT(); 


                }
                break;
            case 25 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:193: LETTER
                {
                mLETTER(); 


                }
                break;
            case 26 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:200: SIMPLEID
                {
                mSIMPLEID(); 


                }
                break;
            case 27 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:209: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 28 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:216: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 29 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:223: OCTAL_ESC
                {
                mOCTAL_ESC(); 


                }
                break;
            case 30 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:233: UNICODE_ESC
                {
                mUNICODE_ESC(); 


                }
                break;
            case 31 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:245: ESC_SEQ
                {
                mESC_SEQ(); 


                }
                break;
            case 32 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:253: STRING
                {
                mSTRING(); 


                }
                break;
            case 33 :
                // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:1:260: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\4\uffff\1\41\1\44\1\uffff\2\53\1\uffff\2\44\1\uffff\2\44\2\uffff"+
        "\1\63\1\65\2\53\4\44\1\74\1\53\1\44\7\uffff\1\42\5\uffff\2\42\1"+
        "\uffff\1\42\3\14\2\42\4\uffff\6\42\2\uffff\2\117\2\uffff\1\122\3"+
        "\11\2\123\6\42\1\117\5\uffff\2\42\2\136\2\42\2\uffff\2\142\1\uffff"+
        "\2\42\2\uffff\2\42\1\uffff\2\151\2\uffff";
    static final String DFA17_eofS =
        "\152\uffff";
    static final String DFA17_minS =
        "\1\11\3\uffff\2\60\1\123\2\60\1\uffff\2\60\1\uffff\2\60\2\uffff"+
        "\2\75\11\60\2\uffff\1\42\4\uffff\1\147\5\uffff\1\104\1\144\1\uffff"+
        "\1\144\3\60\1\122\1\162\4\uffff\1\114\1\154\1\125\1\165\1\113\1"+
        "\153\2\uffff\3\60\1\uffff\6\60\1\123\1\163\1\105\1\145\1\116\1\156"+
        "\1\60\2\uffff\1\60\2\uffff\1\105\1\145\2\60\1\117\1\157\1\uffff"+
        "\3\60\1\uffff\1\127\1\167\1\60\1\uffff\1\116\1\156\1\uffff\2\60"+
        "\2\uffff";
    static final String DFA17_maxS =
        "\1\174\3\uffff\2\172\1\166\2\172\1\uffff\2\172\1\uffff\2\172\2\uffff"+
        "\2\75\6\172\1\71\2\172\2\uffff\1\165\4\uffff\1\147\5\uffff\1\104"+
        "\1\144\1\uffff\1\144\3\172\1\122\1\162\4\uffff\1\114\1\154\1\125"+
        "\1\165\1\113\1\153\2\uffff\2\67\1\146\1\uffff\6\172\1\123\1\163"+
        "\1\105\1\145\1\116\1\156\1\67\2\uffff\1\146\2\uffff\1\105\1\145"+
        "\2\172\1\117\1\157\1\uffff\1\146\2\172\1\uffff\1\127\1\167\1\146"+
        "\1\uffff\1\116\1\156\1\uffff\2\172\2\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\3\5\uffff\1\12\2\uffff\1\13\2\uffff\1\15\1\16"+
        "\13\uffff\1\33\1\34\1\uffff\1\40\1\41\1\4\1\32\1\uffff\1\31\1\6"+
        "\1\7\1\10\1\11\2\uffff\1\30\6\uffff\1\20\1\17\1\22\1\21\6\uffff"+
        "\1\26\1\27\3\uffff\1\37\15\uffff\2\35\1\uffff\1\5\1\14\6\uffff\1"+
        "\35\3\uffff\1\24\3\uffff\1\23\2\uffff\1\36\2\uffff\1\36\1\25";
    static final String DFA17_specialS =
        "\152\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\40\2\uffff\1\40\22\uffff\1\40\1\20\4\uffff\1\11\1\37\1\34"+
            "\1\35\1\uffff\1\1\1\uffff\1\2\1\3\1\uffff\12\31\1\uffff\1\11"+
            "\1\22\1\17\1\21\2\uffff\1\7\4\32\1\23\10\33\1\12\4\33\1\25\1"+
            "\27\2\33\1\15\2\33\1\6\1\36\4\uffff\1\10\3\32\1\4\1\24\10\33"+
            "\1\13\2\33\1\5\1\33\1\26\1\30\2\33\1\16\2\33\1\uffff\1\14",
            "",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\4\42\1\43\25\42",
            "\1\46\1\47\1\50\1\45\34\uffff\1\46\1\47\1\50\1\45",
            "\12\42\7\uffff\15\42\1\51\14\42\4\uffff\1\42\1\uffff\15\42"+
            "\1\52\14\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\15\42\1\54\14\42",
            "",
            "\12\42\7\uffff\21\42\1\55\10\42\4\uffff\1\42\1\uffff\21\42"+
            "\1\56\10\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\21\42\1\57\10\42",
            "",
            "\12\42\7\uffff\16\42\1\60\13\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\16\42\1\61\13\42",
            "",
            "",
            "\1\62",
            "\1\64",
            "\12\42\7\uffff\1\66\31\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\1\67\31\42",
            "\12\42\7\uffff\21\42\1\70\10\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\21\42\1\71\10\42",
            "\12\42\7\uffff\15\42\1\72\14\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\15\42\1\73\14\42",
            "\12\75",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\101\4\uffff\1\101\10\uffff\4\76\4\77\44\uffff\1\101\5\uffff"+
            "\1\101\3\uffff\1\101\7\uffff\1\101\3\uffff\1\101\1\uffff\1\101"+
            "\1\100",
            "",
            "",
            "",
            "",
            "\1\102",
            "",
            "",
            "",
            "",
            "",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\106",
            "\1\107",
            "",
            "",
            "",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "",
            "\10\116",
            "\10\120",
            "\12\121\7\uffff\6\121\32\uffff\6\121",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\10\132",
            "",
            "",
            "\12\133\7\uffff\6\133\32\uffff\6\133",
            "",
            "",
            "\1\134",
            "\1\135",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\137",
            "\1\140",
            "",
            "\12\141\7\uffff\6\141\32\uffff\6\141",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\143",
            "\1\144",
            "\12\145\7\uffff\6\145\32\uffff\6\145",
            "",
            "\1\146",
            "\1\147",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__32 | T__33 | T__34 | T__35 | T__36 | VALUE | SIZE | TYPE | UNIQUE | AND | OR | XOR | EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL | FALSE | TRUE | UNKNOWN | DIGIT | INT | HEX_DIGIT | LETTER | SIMPLEID | LPAREN | RPAREN | OCTAL_ESC | UNICODE_ESC | ESC_SEQ | STRING | WS );";
        }
    }
 

}