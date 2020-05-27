// $ANTLR 3.5.2 MvdXMLv1_1.g 2020-05-05 16:37:25

package generated.mvdxml1dot1.rule_operators;
import java.util.HashMap;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import de.rwth_aachen.dc.mvd.mvdxml1dot1.AbstractRule;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcHashMapBuilder.ObjectToValue;
import nl.tue.ddss.mvdxml1dot1.ifc_check.Metric;
import nl.tue.ddss.mvdxml1dot1.ifc_check.Parameter;
import nl.tue.ddss.mvdxml1dot1.rule_operators.AndOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.EqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.GreaterEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.GreaterOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.InEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.LessEqualOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.LessOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.OrOperator;
import nl.tue.ddss.mvdxml1dot1.rule_operators.XorOperator;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MvdXMLv1_1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "DIGIT", "EQUAL", "ESC_SEQ", 
		"FALSE", "GREATER_THAN", "GREATER_THAN_OR_EQUAL", "HEX_DIGIT", "INT", 
		"LESS_THAN", "LESS_THAN_OR_EQUAL", "LETTER", "LPAREN", "NOT_EQUAL", "OCTAL_ESC", 
		"OR", "RPAREN", "SIMPLEID", "SIZE", "STRING", "TRUE", "TYPE", "UNICODE_ESC", 
		"UNIQUE", "UNKNOWN", "VALUE", "WS", "XOR", "'+'", "'-'", "'.'", "'e'", 
		"'reg'"
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

	@Override public String[] getTokenNames() { return MvdXMLv1_1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "MvdXMLv1_1.g"; }


	HashMap <AbstractRule,ObjectToValue> hashMap;
	public MvdXMLv1_1Parser(TokenStream input,HashMap <AbstractRule,ObjectToValue> hashMap) {
	        this(input, new RecognizerSharedState());
	        this.hashMap=hashMap;
	    }



	// $ANTLR start "expression"
	// MvdXMLv1_1.g:47:1: expression returns [Boolean expressionReturns] : boolean_expression ;
	public final Boolean expression() throws RecognitionException {
		Boolean expressionReturns = null;


		Boolean boolean_expression1 =null;

		try {
			// MvdXMLv1_1.g:48:2: ( boolean_expression )
			// MvdXMLv1_1.g:48:4: boolean_expression
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
	// MvdXMLv1_1.g:53:1: boolean_expression returns [Boolean result] : left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )? ;
	public final Boolean boolean_expression() throws RecognitionException {
		Boolean result = null;


		Boolean left =null;
		Boolean right =null;

		try {
			// MvdXMLv1_1.g:54:6: (left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )? )
			// MvdXMLv1_1.g:54:8: left= boolean_term ( AND right= boolean_expression )? ( OR right= boolean_expression )? ( XOR right= boolean_expression )?
			{
			pushFollow(FOLLOW_boolean_term_in_boolean_expression64);
			left=boolean_term();
			state._fsp--;

			result =left;
			// MvdXMLv1_1.g:54:41: ( AND right= boolean_expression )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==AND) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// MvdXMLv1_1.g:54:42: AND right= boolean_expression
					{
					match(input,AND,FOLLOW_AND_in_boolean_expression68); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression72);
					right=boolean_expression();
					state._fsp--;


					    	AndOperator andOperator=new AndOperator(left,right);
					    	result =andOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:59:6: ( OR right= boolean_expression )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==OR) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// MvdXMLv1_1.g:59:7: OR right= boolean_expression
					{
					match(input,OR,FOLLOW_OR_in_boolean_expression91); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression95);
					right=boolean_expression();
					state._fsp--;


					    	OrOperator orOperator=new OrOperator(left,right);
					      result =orOperator.getResult();
					    	
					}
					break;

			}

			// MvdXMLv1_1.g:64:6: ( XOR right= boolean_expression )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==XOR) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// MvdXMLv1_1.g:64:7: XOR right= boolean_expression
					{
					match(input,XOR,FOLLOW_XOR_in_boolean_expression114); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_expression118);
					right=boolean_expression();
					state._fsp--;


					    	XorOperator xorOperator=new XorOperator(left,right);
					    	
					}
					break;

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
		return result;
	}
	// $ANTLR end "boolean_expression"



	// $ANTLR start "boolean_term"
	// MvdXMLv1_1.g:71:1: boolean_term returns [Boolean boolTermReturns] : ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) );
	public final Boolean boolean_term() throws RecognitionException {
		Boolean boolTermReturns = null;


		Object leftOperand =null;
		String op =null;
		Object rightOperand =null;
		Boolean valueReturns =null;

		try {
			// MvdXMLv1_1.g:72:2: ( ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) ) | ( LPAREN valueReturns= boolean_expression RPAREN ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==SIMPLEID) ) {
				alt7=1;
			}
			else if ( (LA7_0==LPAREN) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// MvdXMLv1_1.g:72:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
					{
					// MvdXMLv1_1.g:72:4: ( (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? ) )
					// MvdXMLv1_1.g:72:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? ) op= operator (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
					{
					// MvdXMLv1_1.g:72:5: (leftOperand= parameter (leftOperand= metric[leftOperand] )? )
					// MvdXMLv1_1.g:72:7: leftOperand= parameter (leftOperand= metric[leftOperand] )?
					{
					pushFollow(FOLLOW_parameter_in_boolean_term166);
					leftOperand=parameter();
					state._fsp--;

					// MvdXMLv1_1.g:72:29: (leftOperand= metric[leftOperand] )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==SIZE||LA4_0==TYPE||LA4_0==UNIQUE||LA4_0==VALUE) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// MvdXMLv1_1.g:72:31: leftOperand= metric[leftOperand]
							{
							pushFollow(FOLLOW_metric_in_boolean_term172);
							leftOperand=metric(leftOperand);
							state._fsp--;

							}
							break;

					}

					}

					pushFollow(FOLLOW_operator_in_boolean_term181);
					op=operator();
					state._fsp--;

					// MvdXMLv1_1.g:72:79: (rightOperand= value |rightOperand= parameter (rightOperand= metric[rightOperand] )? )
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==DIGIT||LA6_0==FALSE||LA6_0==INT||(LA6_0 >= STRING && LA6_0 <= TRUE)||LA6_0==UNKNOWN||(LA6_0 >= 32 && LA6_0 <= 33)||LA6_0==36) ) {
						alt6=1;
					}
					else if ( (LA6_0==SIMPLEID) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						throw nvae;
					}

					switch (alt6) {
						case 1 :
							// MvdXMLv1_1.g:72:81: rightOperand= value
							{
							pushFollow(FOLLOW_value_in_boolean_term187);
							rightOperand=value();
							state._fsp--;

							}
							break;
						case 2 :
							// MvdXMLv1_1.g:72:102: rightOperand= parameter (rightOperand= metric[rightOperand] )?
							{
							pushFollow(FOLLOW_parameter_in_boolean_term193);
							rightOperand=parameter();
							state._fsp--;

							// MvdXMLv1_1.g:72:125: (rightOperand= metric[rightOperand] )?
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0==SIZE||LA5_0==TYPE||LA5_0==UNIQUE||LA5_0==VALUE) ) {
								alt5=1;
							}
							switch (alt5) {
								case 1 :
									// MvdXMLv1_1.g:72:127: rightOperand= metric[rightOperand]
									{
									pushFollow(FOLLOW_metric_in_boolean_term199);
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
					// MvdXMLv1_1.g:92:5: ( LPAREN valueReturns= boolean_expression RPAREN )
					{
					// MvdXMLv1_1.g:92:5: ( LPAREN valueReturns= boolean_expression RPAREN )
					// MvdXMLv1_1.g:92:7: LPAREN valueReturns= boolean_expression RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_boolean_term217); 
					pushFollow(FOLLOW_boolean_expression_in_boolean_term221);
					valueReturns=boolean_expression();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_boolean_term223); 
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
	// MvdXMLv1_1.g:95:1: parameter returns [Object paraReturns] : SIMPLEID ;
	public final Object parameter() throws RecognitionException {
		Object paraReturns = null;


		Token SIMPLEID2=null;

		try {
			// MvdXMLv1_1.g:96:2: ( SIMPLEID )
			// MvdXMLv1_1.g:96:4: SIMPLEID
			{
			SIMPLEID2=(Token)match(input,SIMPLEID,FOLLOW_SIMPLEID_in_parameter241); 
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
	// MvdXMLv1_1.g:100:1: metric[Object value] returns [Object metricReturns] : ( VALUE | SIZE | TYPE | UNIQUE );
	public final Object metric(Object value) throws RecognitionException {
		Object metricReturns = null;


		try {
			// MvdXMLv1_1.g:101:2: ( VALUE | SIZE | TYPE | UNIQUE )
			int alt8=4;
			switch ( input.LA(1) ) {
			case VALUE:
				{
				alt8=1;
				}
				break;
			case SIZE:
				{
				alt8=2;
				}
				break;
			case TYPE:
				{
				alt8=3;
				}
				break;
			case UNIQUE:
				{
				alt8=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// MvdXMLv1_1.g:101:4: VALUE
					{
					match(input,VALUE,FOLLOW_VALUE_in_metric260); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricValue();
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:102:4: SIZE
					{
					match(input,SIZE,FOLLOW_SIZE_in_metric267); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricSize();
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:103:4: TYPE
					{
					match(input,TYPE,FOLLOW_TYPE_in_metric274); 
					Metric metric=new Metric(value);metricReturns =metric.getMetricType();
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:103:84: UNIQUE
					{
					match(input,UNIQUE,FOLLOW_UNIQUE_in_metric279); 
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



	// $ANTLR start "operator"
	// MvdXMLv1_1.g:106:1: operator returns [String op] : ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL );
	public final String operator() throws RecognitionException {
		String op = null;


		try {
			// MvdXMLv1_1.g:107:2: ( EQUAL | NOT_EQUAL | GREATER_THAN | GREATER_THAN_OR_EQUAL | LESS_THAN | LESS_THAN_OR_EQUAL )
			int alt9=6;
			switch ( input.LA(1) ) {
			case EQUAL:
				{
				alt9=1;
				}
				break;
			case NOT_EQUAL:
				{
				alt9=2;
				}
				break;
			case GREATER_THAN:
				{
				alt9=3;
				}
				break;
			case GREATER_THAN_OR_EQUAL:
				{
				alt9=4;
				}
				break;
			case LESS_THAN:
				{
				alt9=5;
				}
				break;
			case LESS_THAN_OR_EQUAL:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// MvdXMLv1_1.g:107:4: EQUAL
					{
					match(input,EQUAL,FOLLOW_EQUAL_in_operator293); 
					op ="=";
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:107:22: NOT_EQUAL
					{
					match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_operator298); 
					op ="!=";
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:107:45: GREATER_THAN
					{
					match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_operator303); 
					op =">";
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:107:71: GREATER_THAN_OR_EQUAL
					{
					match(input,GREATER_THAN_OR_EQUAL,FOLLOW_GREATER_THAN_OR_EQUAL_in_operator309); 
					op =">=";
					}
					break;
				case 5 :
					// MvdXMLv1_1.g:107:106: LESS_THAN
					{
					match(input,LESS_THAN,FOLLOW_LESS_THAN_in_operator314); 
					op ="<";
					}
					break;
				case 6 :
					// MvdXMLv1_1.g:107:128: LESS_THAN_OR_EQUAL
					{
					match(input,LESS_THAN_OR_EQUAL,FOLLOW_LESS_THAN_OR_EQUAL_in_operator319); 
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
	// MvdXMLv1_1.g:109:1: value returns [Object valueReturns] : ( logical_literal | real_literal | string_literal | regular_expression );
	public final Object value() throws RecognitionException {
		Object valueReturns = null;


		Boolean logical_literal3 =null;
		ParserRuleReturnScope real_literal4 =null;
		String string_literal5 =null;
		String regular_expression6 =null;

		try {
			// MvdXMLv1_1.g:110:2: ( logical_literal | real_literal | string_literal | regular_expression )
			int alt10=4;
			switch ( input.LA(1) ) {
			case FALSE:
			case TRUE:
			case UNKNOWN:
				{
				alt10=1;
				}
				break;
			case DIGIT:
			case INT:
			case 32:
			case 33:
				{
				alt10=2;
				}
				break;
			case STRING:
				{
				alt10=3;
				}
				break;
			case 36:
				{
				alt10=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// MvdXMLv1_1.g:110:4: logical_literal
					{
					pushFollow(FOLLOW_logical_literal_in_value334);
					logical_literal3=logical_literal();
					state._fsp--;


						valueReturns =logical_literal3;
						
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:112:6: real_literal
					{
					pushFollow(FOLLOW_real_literal_in_value339);
					real_literal4=real_literal();
					state._fsp--;


					  valueReturns =(real_literal4!=null?((MvdXMLv1_1Parser.real_literal_return)real_literal4).realReturns:null);
					  
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:114:6: string_literal
					{
					pushFollow(FOLLOW_string_literal_in_value344);
					string_literal5=string_literal();
					state._fsp--;


					  valueReturns =string_literal5;
					  
					}
					break;
				case 4 :
					// MvdXMLv1_1.g:116:6: regular_expression
					{
					pushFollow(FOLLOW_regular_expression_in_value349);
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
	// MvdXMLv1_1.g:120:1: logical_literal returns [Boolean logicalReturns] : ( FALSE | TRUE | UNKNOWN );
	public final Boolean logical_literal() throws RecognitionException {
		Boolean logicalReturns = null;


		try {
			// MvdXMLv1_1.g:121:2: ( FALSE | TRUE | UNKNOWN )
			int alt11=3;
			switch ( input.LA(1) ) {
			case FALSE:
				{
				alt11=1;
				}
				break;
			case TRUE:
				{
				alt11=2;
				}
				break;
			case UNKNOWN:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// MvdXMLv1_1.g:121:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_logical_literal365); 
					logicalReturns =false;
					}
					break;
				case 2 :
					// MvdXMLv1_1.g:121:37: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_logical_literal370); 
					logicalReturns =true;
					}
					break;
				case 3 :
					// MvdXMLv1_1.g:121:67: UNKNOWN
					{
					match(input,UNKNOWN,FOLLOW_UNKNOWN_in_logical_literal375); 
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
	// MvdXMLv1_1.g:123:1: real_literal returns [Double realReturns] : ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? ;
	public final MvdXMLv1_1Parser.real_literal_return real_literal() throws RecognitionException {
		MvdXMLv1_1Parser.real_literal_return retval = new MvdXMLv1_1Parser.real_literal_return();
		retval.start = input.LT(1);

		try {
			// MvdXMLv1_1.g:124:2: ( ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )? )
			// MvdXMLv1_1.g:124:4: ( sign )? ( DIGIT | INT ) ( '.' )? ( ( DIGIT | INT ) )? ( 'e' ( sign )? ( DIGIT | INT ) )?
			{
			// MvdXMLv1_1.g:124:4: ( sign )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= 32 && LA12_0 <= 33)) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// MvdXMLv1_1.g:124:5: sign
					{
					pushFollow(FOLLOW_sign_in_real_literal390);
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
			// MvdXMLv1_1.g:124:28: ( '.' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==34) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// MvdXMLv1_1.g:124:29: '.'
					{
					match(input,34,FOLLOW_34_in_real_literal405); 
					}
					break;

			}

			// MvdXMLv1_1.g:124:35: ( ( DIGIT | INT ) )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==DIGIT||LA14_0==INT) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// MvdXMLv1_1.g:
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

			// MvdXMLv1_1.g:124:56: ( 'e' ( sign )? ( DIGIT | INT ) )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==35) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// MvdXMLv1_1.g:124:58: 'e' ( sign )? ( DIGIT | INT )
					{
					match(input,35,FOLLOW_35_in_real_literal426); 
					// MvdXMLv1_1.g:124:62: ( sign )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( ((LA15_0 >= 32 && LA15_0 <= 33)) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// MvdXMLv1_1.g:124:63: sign
							{
							pushFollow(FOLLOW_sign_in_real_literal429);
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
	// MvdXMLv1_1.g:126:1: string_literal returns [String stringReturns] : STRING ;
	public final String string_literal() throws RecognitionException {
		String stringReturns = null;


		Token STRING7=null;

		try {
			// MvdXMLv1_1.g:127:2: ( STRING )
			// MvdXMLv1_1.g:127:4: STRING
			{
			STRING7=(Token)match(input,STRING,FOLLOW_STRING_in_string_literal460); 
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
	// MvdXMLv1_1.g:129:1: regular_expression returns [String regReturns] : 'reg' STRING ;
	public final String regular_expression() throws RecognitionException {
		String regReturns = null;


		Token STRING8=null;

		try {
			// MvdXMLv1_1.g:130:2: ( 'reg' STRING )
			// MvdXMLv1_1.g:130:4: 'reg' STRING
			{
			match(input,36,FOLLOW_36_in_regular_expression476); 
			STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_regular_expression478); 
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
	// MvdXMLv1_1.g:131:1: sign : ( '+' | '-' );
	public final void sign() throws RecognitionException {
		try {
			// MvdXMLv1_1.g:132:2: ( '+' | '-' )
			// MvdXMLv1_1.g:
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
	}
	// $ANTLR end "sign"

	// Delegated rules



	public static final BitSet FOLLOW_boolean_expression_in_expression37 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolean_term_in_boolean_expression64 = new BitSet(new long[]{0x0000000080080012L});
	public static final BitSet FOLLOW_AND_in_boolean_expression68 = new BitSet(new long[]{0x0000000000210000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression72 = new BitSet(new long[]{0x0000000080080002L});
	public static final BitSet FOLLOW_OR_in_boolean_expression91 = new BitSet(new long[]{0x0000000000210000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression95 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_XOR_in_boolean_expression114 = new BitSet(new long[]{0x0000000000210000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_expression118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_in_boolean_term166 = new BitSet(new long[]{0x000000002A426640L});
	public static final BitSet FOLLOW_metric_in_boolean_term172 = new BitSet(new long[]{0x0000000000026640L});
	public static final BitSet FOLLOW_operator_in_boolean_term181 = new BitSet(new long[]{0x0000001311A01120L});
	public static final BitSet FOLLOW_value_in_boolean_term187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_in_boolean_term193 = new BitSet(new long[]{0x000000002A400002L});
	public static final BitSet FOLLOW_metric_in_boolean_term199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_term217 = new BitSet(new long[]{0x0000000000210000L});
	public static final BitSet FOLLOW_boolean_expression_in_boolean_term221 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_term223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIMPLEID_in_parameter241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUE_in_metric260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIZE_in_metric267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_metric274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNIQUE_in_metric279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUAL_in_operator293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_EQUAL_in_operator298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_THAN_in_operator303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_THAN_OR_EQUAL_in_operator309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_THAN_in_operator314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_THAN_OR_EQUAL_in_operator319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_literal_in_value334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_literal_in_value339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_string_literal_in_value344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_regular_expression_in_value349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_logical_literal365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_logical_literal370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNKNOWN_in_logical_literal375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sign_in_real_literal390 = new BitSet(new long[]{0x0000000000001020L});
	public static final BitSet FOLLOW_set_in_real_literal394 = new BitSet(new long[]{0x0000000C00001022L});
	public static final BitSet FOLLOW_34_in_real_literal405 = new BitSet(new long[]{0x0000000800001022L});
	public static final BitSet FOLLOW_35_in_real_literal426 = new BitSet(new long[]{0x0000000300001020L});
	public static final BitSet FOLLOW_sign_in_real_literal429 = new BitSet(new long[]{0x0000000000001020L});
	public static final BitSet FOLLOW_set_in_real_literal433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_string_literal460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_regular_expression476 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_STRING_in_regular_expression478 = new BitSet(new long[]{0x0000000000000002L});
}
