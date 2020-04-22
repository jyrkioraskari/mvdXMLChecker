// $ANTLR 3.4 E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g 2016-05-10 15:28:17

package nl.tue.ddss.rule_parse;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.bimserver.ifc.IfcModel;
import org.buildingsmart_tech.mvdxml.mvdxml1_1.*;
import nl.tue.ddss.ifc_check.IfcHashMapBuilder.ObjectToValue;
import nl.tue.ddss.ifc_check.Parameter;
import nl.tue.ddss.ifc_check.Metric;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MvdXMLv1_1Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "DIGIT", "EQUAL", "ESC_SEQ", "FALSE", "GREATER_THAN", "GREATER_THAN_OR_EQUAL", "HEX_DIGIT", "INT", "LESS_THAN", "LESS_THAN_OR_EQUAL", "LETTER", "LPAREN", "NOT_EQUAL", "OCTAL_ESC", "OR", "RPAREN", "SIMPLEID", "SIZE", "STRING", "TRUE", "TYPE", "UNICODE_ESC", "UNIQUE", "UNKNOWN", "VALUE", "WS", "XOR", "'+'", "'-'", "'.'", "'e'", "'reg'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public MvdXMLv1_1Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MvdXMLv1_1Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return MvdXMLv1_1Parser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g"; }


    HashMap <AbstractRule,ObjectToValue> hashMap;
    public MvdXMLv1_1Parser(TokenStream input,HashMap <AbstractRule,ObjectToValue> hashMap) {
            this(input, new RecognizerSharedState());
            this.hashMap=hashMap;
        }



    // $ANTLR start "expression"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:33:1: expression returns [Boolean expressionReturns] : boolean_expression ;
    public final Boolean expression() throws RecognitionException {
        Boolean expressionReturns = null;


        Boolean boolean_expression1 =null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:34:2: ( boolean_expression )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:34:4: boolean_expression
            {
            pushFollow(FOLLOW_boolean_expression_in_expression37);
            boolean_expression1=boolean_expression();

            state._fsp--;


            expressionReturns =boolean_expression1;
            	

            }

        }
        catch (RecognitionException re) {

            	
        }

        finally {
        	// do for sure before leaving
        }
        return expressionReturns;
    }
    // $ANTLR end "expression"



    // $ANTLR start "boolean_expression"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:38:1: boolean_expression returns [Boolean result] : left= boolean_term (logical= logical_interconnection right= boolean_term )* ;
    public final Boolean boolean_expression() throws RecognitionException {
        Boolean result = null;


        Boolean left =null;

        String logical =null;

        Boolean right =null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:39:6: (left= boolean_term (logical= logical_interconnection right= boolean_term )* )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:39:8: left= boolean_term (logical= logical_interconnection right= boolean_term )*
            {
            pushFollow(FOLLOW_boolean_term_in_boolean_expression62);
            left=boolean_term();

            state._fsp--;


            result =left;

            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:39:41: (logical= logical_interconnection right= boolean_term )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==AND||LA1_0==OR||LA1_0==XOR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:39:42: logical= logical_interconnection right= boolean_term
            	    {
            	    pushFollow(FOLLOW_logical_interconnection_in_boolean_expression68);
            	    logical=logical_interconnection();

            	    state._fsp--;


            	    pushFollow(FOLLOW_boolean_term_in_boolean_expression72);
            	    right=boolean_term();

            	    state._fsp--;


            	    if (logical.equals("AND")) {
            	        	AndOperator andOperator=new AndOperator(left,right);
            	        	result =andOperator.getResult();
            	        	}else if (logical.equals("OR")) {
            	          OrOperator orOperator=new OrOperator(left,right);
            	          result =orOperator.getResult();
            	          }else if (logical.equals("XOR")) {
            	          XorOperator xorOperator=new XorOperator(left,right);
            	          result =xorOperator.getResult();
            	          }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "boolean_expression"



    // $ANTLR start "boolean_term"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:50:1: boolean_term returns [Boolean boolTermReturns] : ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) );
    public final Boolean boolean_term() throws RecognitionException {
        Boolean boolTermReturns = null;


        Object leftOperand =null;

        String op =null;

        Object rightOperand =null;

        Boolean valueReturns =null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:2: ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SIMPLEID) ) {
                alt5=1;
            }
            else if ( (LA5_0==LPAREN) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
                    {
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
                    {
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? )
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:7: leftOperand= parameter (leftOperand= metric[leftOperand] )?
                    {
                    pushFollow(FOLLOW_parameter_in_boolean_term101);
                    leftOperand=parameter();

                    state._fsp--;


                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:29: (leftOperand= metric[leftOperand] )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==SIZE||LA2_0==TYPE||LA2_0==UNIQUE||LA2_0==VALUE) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:31: leftOperand= metric[leftOperand]
                            {
                            pushFollow(FOLLOW_metric_in_boolean_term107);
                            leftOperand=metric(leftOperand);

                            state._fsp--;


                            }
                            break;

                    }


                    }


                    pushFollow(FOLLOW_operator_in_boolean_term116);
                    op=operator();

                    state._fsp--;


                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:79: (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==DIGIT||LA4_0==FALSE||LA4_0==INT||(LA4_0 >= STRING && LA4_0 <= TRUE)||LA4_0==UNKNOWN||(LA4_0 >= 32 && LA4_0 <= 33)||LA4_0==36) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==SIMPLEID) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }
                    switch (alt4) {
                        case 1 :
                            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:81: rightOperand= value
                            {
                            pushFollow(FOLLOW_value_in_boolean_term122);
                            rightOperand=value();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:102: rightOperand= parameter (rightOperand= metric[rightOperand] )?
                            {
                            pushFollow(FOLLOW_parameter_in_boolean_term128);
                            rightOperand=parameter();

                            state._fsp--;


                            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:125: (rightOperand= metric[rightOperand] )?
                            int alt3=2;
                            int LA3_0 = input.LA(1);

                            if ( (LA3_0==SIZE||LA3_0==TYPE||LA3_0==UNIQUE||LA3_0==VALUE) ) {
                                alt3=1;
                            }
                            switch (alt3) {
                                case 1 :
                                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:51:127: rightOperand= metric[rightOperand]
                                    {
                                    pushFollow(FOLLOW_metric_in_boolean_term134);
                                    rightOperand=metric(rightOperand);

                                    state._fsp--;


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    if (op.equals("=")){
                    	 EqualOperator equalOperator=new EqualOperator(leftOperand,rightOperand);
                    	 boolTermReturns =equalOperator.getResult();
                       }if (op.equals(">")){
                       GreaterOperator greaterOperator=new GreaterOperator(leftOperand,rightOperand);
                       boolTermReturns =greaterOperator.getResult();
                       }if (op.equals("<")){
                       LessOperator lessOperator=new LessOperator(leftOperand,rightOperand);
                       boolTermReturns =lessOperator.getResult();
                       }if (op.equals(">=")){
                       GreaterEqualOperator greaterEqualOperator=new GreaterEqualOperator(leftOperand,rightOperand);
                       boolTermReturns =greaterEqualOperator.getResult();
                       }if (op.equals("<=")){
                       LessEqualOperator lessEqualOperator=new LessEqualOperator(leftOperand,rightOperand);
                       boolTermReturns =lessEqualOperator.getResult();
                       }if (op.equals("!=")){
                       InEqualOperator inEqualOperator=new InEqualOperator(leftOperand,rightOperand);
                       boolTermReturns =inEqualOperator.getResult();
                       }  


                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:71:5: ( LPAREN valueReturns= boolean_expression RPAREN )
                    {
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:71:5: ( LPAREN valueReturns= boolean_expression RPAREN )
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:71:7: LPAREN valueReturns= boolean_expression RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_boolean_term152); 

                    pushFollow(FOLLOW_boolean_expression_in_boolean_term156);
                    valueReturns=boolean_expression();

                    state._fsp--;


                    match(input,RPAREN,FOLLOW_RPAREN_in_boolean_term158); 

                    }


                    boolTermReturns =valueReturns;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return boolTermReturns;
    }
    // $ANTLR end "boolean_term"



    // $ANTLR start "parameter"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:72:1: parameter returns [Object paraReturns] : SIMPLEID ;
    public final Object parameter() throws RecognitionException {
        Object paraReturns = null;


        Token SIMPLEID2=null;

        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:73:2: ( SIMPLEID )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:73:4: SIMPLEID
            {
            SIMPLEID2=(Token)match(input,SIMPLEID,FOLLOW_SIMPLEID_in_parameter174); 

            Parameter parameter=new Parameter((SIMPLEID2!=null?SIMPLEID2.getText():null),hashMap);
            	paraReturns =parameter.getResult();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return paraReturns;
    }
    // $ANTLR end "parameter"



    // $ANTLR start "metric"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:76:1: metric[Object value] returns [Object metricReturns] : ( VALUE | SIZE | TYPE | UNIQUE );
    public final Object metric(Object value) throws RecognitionException {
        Object metricReturns = null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:77:2: ( VALUE | SIZE | TYPE | UNIQUE )
            int alt6=4;
            switch ( input.LA(1) ) {
            case VALUE:
                {
                alt6=1;
                }
                break;
            case SIZE:
                {
                alt6=2;
                }
                break;
            case TYPE:
                {
                alt6=3;
                }
                break;
            case UNIQUE:
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
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:77:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_metric191); 

                    Metric metric=new Metric(value);metricReturns =metric.getMetricValue();

                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:78:4: SIZE
                    {
                    match(input,SIZE,FOLLOW_SIZE_in_metric198); 

                    Metric metric=new Metric(value);metricReturns =metric.getMetricSize();

                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:79:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_metric205); 

                    Metric metric=new Metric(value);metricReturns =metric.getMetricType();

                    }
                    break;
                case 4 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:79:84: UNIQUE
                    {
                    match(input,UNIQUE,FOLLOW_UNIQUE_in_metric210); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return metricReturns;
    }
    // $ANTLR end "metric"



    // $ANTLR start "logical_interconnection"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:80:1: logical_interconnection returns [String logical] : ( AND | OR | XOR );
    public final String logical_interconnection() throws RecognitionException {
        String logical = null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:81:2: ( AND | OR | XOR )
            int alt7=3;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt7=1;
                }
                break;
            case OR:
                {
                alt7=2;
                }
                break;
            case XOR:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:81:4: AND
                    {
                    match(input,AND,FOLLOW_AND_in_logical_interconnection222); 

                    logical ="AND";

                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:81:27: OR
                    {
                    match(input,OR,FOLLOW_OR_in_logical_interconnection227); 

                    logical ="OR";

                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:81:48: XOR
                    {
                    match(input,XOR,FOLLOW_XOR_in_logical_interconnection232); 

                    logical ="XOR";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return logical;
    }
    // $ANTLR end "logical_interconnection"



    // $ANTLR start "operator"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:82:1: operator returns [String op] : ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL );
    public final String operator() throws RecognitionException {
        String op = null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:2: ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL )
            int alt8=6;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt8=1;
                }
                break;
            case NOT_EQUAL:
                {
                alt8=2;
                }
                break;
            case GREATER_THAN:
                {
                alt8=3;
                }
                break;
            case GREATER_THAN_OR_EQUAL:
                {
                alt8=4;
                }
                break;
            case LESS_THAN:
                {
                alt8=5;
                }
                break;
            case LESS_THAN_OR_EQUAL:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:4: EQUAL
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_operator245); 

                    op ="=";

                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:22: NOT_EQUAL
                    {
                    match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_operator250); 

                    op ="!=";

                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:45: GREATER_THAN
                    {
                    match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_operator255); 

                    op =">";

                    }
                    break;
                case 4 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:71: GREATER_THAN_OR_EQUAL
                    {
                    match(input,GREATER_THAN_OR_EQUAL,FOLLOW_GREATER_THAN_OR_EQUAL_in_operator261); 

                    op =">=";

                    }
                    break;
                case 5 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:106: LESS_THAN
                    {
                    match(input,LESS_THAN,FOLLOW_LESS_THAN_in_operator266); 

                    op ="<";

                    }
                    break;
                case 6 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:83:128: LESS_THAN_OR_EQUAL
                    {
                    match(input,LESS_THAN_OR_EQUAL,FOLLOW_LESS_THAN_OR_EQUAL_in_operator271); 

                    op ="<=";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return op;
    }
    // $ANTLR end "operator"



    // $ANTLR start "value"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:84:1: value returns [Object valueReturns] : ( logical_literal | real_literal | string_literal | regular_expression );
    public final Object value() throws RecognitionException {
        Object valueReturns = null;


        Boolean logical_literal3 =null;

        MvdXMLv1_1Parser.real_literal_return real_literal4 =null;

        String string_literal5 =null;

        String regular_expression6 =null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:85:2: ( logical_literal | real_literal | string_literal | regular_expression )
            int alt9=4;
            switch ( input.LA(1) ) {
            case FALSE:
            case TRUE:
            case UNKNOWN:
                {
                alt9=1;
                }
                break;
            case DIGIT:
            case INT:
            case 32:
            case 33:
                {
                alt9=2;
                }
                break;
            case STRING:
                {
                alt9=3;
                }
                break;
            case 36:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:85:4: logical_literal
                    {
                    pushFollow(FOLLOW_logical_literal_in_value284);
                    logical_literal3=logical_literal();

                    state._fsp--;



                    	valueReturns =logical_literal3;
                    	

                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:87:6: real_literal
                    {
                    pushFollow(FOLLOW_real_literal_in_value289);
                    real_literal4=real_literal();

                    state._fsp--;



                      valueReturns =(real_literal4!=null?real_literal4.realReturns:null);
                      

                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:89:6: string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_value294);
                    string_literal5=string_literal();

                    state._fsp--;



                      valueReturns =string_literal5;
                      

                    }
                    break;
                case 4 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:91:6: regular_expression
                    {
                    pushFollow(FOLLOW_regular_expression_in_value299);
                    regular_expression6=regular_expression();

                    state._fsp--;



                      valueReturns =regular_expression6;
                      

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return valueReturns;
    }
    // $ANTLR end "value"



    // $ANTLR start "logical_literal"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:94:1: logical_literal returns [Boolean logicalReturns] : ( FALSE | TRUE | UNKNOWN );
    public final Boolean logical_literal() throws RecognitionException {
        Boolean logicalReturns = null;


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:95:2: ( FALSE | TRUE | UNKNOWN )
            int alt10=3;
            switch ( input.LA(1) ) {
            case FALSE:
                {
                alt10=1;
                }
                break;
            case TRUE:
                {
                alt10=2;
                }
                break;
            case UNKNOWN:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:95:5: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_logical_literal312); 

                    logicalReturns =false;

                    }
                    break;
                case 2 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:95:37: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_logical_literal317); 

                    logicalReturns =true;

                    }
                    break;
                case 3 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:95:67: UNKNOWN
                    {
                    match(input,UNKNOWN,FOLLOW_UNKNOWN_in_logical_literal322); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return logicalReturns;
    }
    // $ANTLR end "logical_literal"


    public static class real_literal_return extends ParserRuleReturnScope {
        public Double realReturns;
    };


    // $ANTLR start "real_literal"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:96:1: real_literal returns [Double realReturns] : ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? ;
    public final MvdXMLv1_1Parser.real_literal_return real_literal() throws RecognitionException {
        MvdXMLv1_1Parser.real_literal_return retval = new MvdXMLv1_1Parser.real_literal_return();
        retval.start = input.LT(1);


        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:2: ( ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:4: ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )?
            {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:4: ( sign )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0 >= 32 && LA11_0 <= 33)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:5: sign
                    {
                    pushFollow(FOLLOW_sign_in_real_literal335);
                    sign();

                    state._fsp--;


                    }
                    break;

            }


            if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:28: ( '.' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==34) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:29: '.'
                    {
                    match(input,34,FOLLOW_34_in_real_literal350); 

                    }
                    break;

            }


            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:35: ( ( DIGIT | INT ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==DIGIT||LA13_0==INT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
                    {
                    if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:56: ( 'e' ( sign )? ( DIGIT | INT ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:58: 'e' ( sign )? ( DIGIT | INT )
                    {
                    match(input,35,FOLLOW_35_in_real_literal371); 

                    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:62: ( sign )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0 >= 32 && LA14_0 <= 33)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:97:63: sign
                            {
                            pushFollow(FOLLOW_sign_in_real_literal374);
                            sign();

                            state._fsp--;


                            }
                            break;

                    }


                    if ( input.LA(1)==DIGIT||input.LA(1)==INT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            retval.realReturns =Double.parseDouble(input.toString(retval.start,input.LT(-1)));

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_literal"



    // $ANTLR start "string_literal"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:98:1: string_literal returns [String stringReturns] : STRING ;
    public final String string_literal() throws RecognitionException {
        String stringReturns = null;


        Token STRING7=null;

        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:99:2: ( STRING )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:99:4: STRING
            {
            STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_string_literal403); 

            stringReturns =(STRING7!=null?STRING7.getText():null).substring(1,(STRING7!=null?STRING7.getText():null).length()-1);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return stringReturns;
    }
    // $ANTLR end "string_literal"



    // $ANTLR start "regular_expression"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:100:1: regular_expression returns [String regReturns] : 'reg' STRING ;
    public final String regular_expression() throws RecognitionException {
        String regReturns = null;


        Token STRING8=null;

        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:101:2: ( 'reg' STRING )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:101:4: 'reg' STRING
            {
            match(input,36,FOLLOW_36_in_regular_expression417); 

            STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_regular_expression419); 

            regReturns ="reg "+(STRING8!=null?STRING8.getText():null).substring(1,(STRING8!=null?STRING8.getText():null).length()-1);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return regReturns;
    }
    // $ANTLR end "regular_expression"



    // $ANTLR start "sign"
    // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:102:1: sign : ( '+' | '-' );
    public final void sign() throws RecognitionException {
        try {
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:103:2: ( '+' | '-' )
            // E:\\Demo\\MvdxmlChecker\\src\\nl\\tue\\ddss\\rule_parse\\MvdXMLv1_1.g:
            {
            if ( (input.LA(1) >= 32 && input.LA(1) <= 33) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "sign"

    // Delegated rules


 

    public static final BitSet FOLLOW_boolean_expression_in_expression37 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_term_in_boolean_expression62 = new BitSet(new long[]{0x0000000080080012L});
    public static final BitSet FOLLOW_logical_interconnection_in_boolean_expression68 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_boolean_term_in_boolean_expression72 = new BitSet(new long[]{0x0000000080080012L});
    public static final BitSet FOLLOW_parameter_in_boolean_term101 = new BitSet(new long[]{0x000000002A426640L});
    public static final BitSet FOLLOW_metric_in_boolean_term107 = new BitSet(new long[]{0x0000000000026640L});
    public static final BitSet FOLLOW_operator_in_boolean_term116 = new BitSet(new long[]{0x0000001311A01120L});
    public static final BitSet FOLLOW_value_in_boolean_term122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_boolean_term128 = new BitSet(new long[]{0x000000002A400002L});
    public static final BitSet FOLLOW_metric_in_boolean_term134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolean_term152 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_boolean_expression_in_boolean_term156 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_boolean_term158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIMPLEID_in_parameter174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_metric191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZE_in_metric198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_metric205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIQUE_in_metric210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_logical_interconnection222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_logical_interconnection227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_XOR_in_logical_interconnection232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_operator245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_operator250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_in_operator255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_THAN_OR_EQUAL_in_operator261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_in_operator266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_THAN_OR_EQUAL_in_operator271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_literal_in_value284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_literal_in_value289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_value294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regular_expression_in_value299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_logical_literal312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_logical_literal317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNKNOWN_in_logical_literal322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sign_in_real_literal335 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_set_in_real_literal339 = new BitSet(new long[]{0x0000000C00001022L});
    public static final BitSet FOLLOW_34_in_real_literal350 = new BitSet(new long[]{0x0000000800001022L});
    public static final BitSet FOLLOW_35_in_real_literal371 = new BitSet(new long[]{0x0000000300001020L});
    public static final BitSet FOLLOW_sign_in_real_literal374 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_set_in_real_literal378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string_literal403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_regular_expression417 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_STRING_in_regular_expression419 = new BitSet(new long[]{0x0000000000000002L});

}