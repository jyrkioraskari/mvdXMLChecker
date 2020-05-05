grammar MvdXMLv1_1;

@header {
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

}

@lexer::header {
package generated.mvdxml1dot1.rule_operators;
}

@members{
HashMap <AbstractRule,ObjectToValue> hashMap;
public MvdXMLv1_1Parser(TokenStream input,HashMap <AbstractRule,ObjectToValue> hashMap) {
        this(input, new RecognizerSharedState());
        this.hashMap=hashMap;
    }
}

/*----------------
* PARSER RULES
*----------------*/
expression returns [Boolean expressionReturns]
	:	boolean_expression {$expressionReturns=$boolean_expression.result;
	};
	catch[RecognitionException re]{
	}
	
boolean_expression returns [Boolean result]
    	:	left=boolean_term {$result=left;}(AND right=boolean_expression
    	{
    	AndOperator andOperator=new AndOperator(left,right);
    	$result=andOperator.getResult();
    	} )? 
    	(OR right=boolean_expression
    	{
    	OrOperator orOperator=new OrOperator(left,right);
      $result=orOperator.getResult();
    	} )? 
    	(XOR right=boolean_expression
    	{
    	XorOperator xorOperator=new XorOperator(left,right);
    	} )? 
    	
    	 ;
      
boolean_term returns [Boolean boolTermReturns]
	:	(( leftOperand=parameter ( leftOperand=metric[leftOperand] )?) op=operator ( rightOperand=value | rightOperand=parameter ( rightOperand=metric[rightOperand] )? ) )
	 {if (op.equals("=")){
	 EqualOperator equalOperator=new EqualOperator(leftOperand,rightOperand);
	 $boolTermReturns=equalOperator.getResult();
   }if (op.equals(">")){
   GreaterOperator greaterOperator=new GreaterOperator(leftOperand,rightOperand);
   $boolTermReturns=greaterOperator.getResult();
   }if (op.equals("<")){
   LessOperator lessOperator=new LessOperator(leftOperand,rightOperand);
   $boolTermReturns=lessOperator.getResult();
   }if (op.equals(">=")){
   GreaterEqualOperator greaterEqualOperator=new GreaterEqualOperator(leftOperand,rightOperand);
   $boolTermReturns=greaterEqualOperator.getResult();
   }if (op.equals("<=")){
   LessEqualOperator lessEqualOperator=new LessEqualOperator(leftOperand,rightOperand);
   $boolTermReturns=lessEqualOperator.getResult();
   }if (op.equals("!=")){
   InEqualOperator inEqualOperator=new InEqualOperator(leftOperand,rightOperand);
   $boolTermReturns=inEqualOperator.getResult();
   }  
}|  ( LPAREN valueReturns=boolean_expression RPAREN ){$boolTermReturns=valueReturns;};


parameter returns [Object paraReturns] 
	:	SIMPLEID {Parameter parameter=new Parameter($SIMPLEID.text,hashMap);
	$paraReturns=parameter.getResult();
	};
	
metric [Object value]returns [Object metricReturns] 	
	:	VALUE {Metric metric=new Metric($value);$metricReturns=metric.getMetricValue();}
	| SIZE {Metric metric=new Metric($value);$metricReturns=metric.getMetricSize();}
	| TYPE {Metric metric=new Metric($value);$metricReturns=metric.getMetricType();}| UNIQUE;
	

operator returns[String op]
	:	EQUAL {$op="=";}| NOT_EQUAL{$op="!=";} | GREATER_THAN {$op=">";} | GREATER_THAN_OR_EQUAL {$op=">=";}| LESS_THAN {$op="<";}| LESS_THAN_OR_EQUAL{$op="<=";};
	
value returns[Object valueReturns]	
	:	logical_literal{
	$valueReturns=$logical_literal.logicalReturns;
	} | real_literal {
  $valueReturns=$real_literal.realReturns;
  }| string_literal {
  $valueReturns=$string_literal.stringReturns;
  }| regular_expression{
  $valueReturns=$regular_expression.regReturns;
  };
  
logical_literal	returns[Boolean logicalReturns]
	: 	FALSE {$logicalReturns=false;}| TRUE {$logicalReturns=true;}| UNKNOWN ;
	
real_literal returns[Double realReturns]
	:	(sign)? ( DIGIT | INT ) ('.')? ( ( DIGIT | INT ) )? ( 'e' (sign)? ( DIGIT | INT ) )? {$realReturns=Double.parseDouble($real_literal.text);};
	
string_literal returns [String stringReturns]
	:	STRING {$stringReturns=$STRING.text.substring(1,$STRING.text.length()-1);};
	
regular_expression returns [String regReturns]
	:	'reg' STRING {$regReturns="reg "+$STRING.text.substring(1,$STRING.text.length()-1);};
sign 	
	:	'+' | '-' ;

/*----------------
* LEXER RULES

*----------------*/
VALUE
  : '[Value]' | '[value]' | '[VALUE]' ;
SIZE
  : '[Size]' | '[size]' | '[SIZE]' ;
TYPE
  : '[Type]' | '[type]' | '[TYPE]' ;
UNIQUE
  : '[Unique]' | '[unique]' | '[UNIQUE]' ;
AND 	
	:	'AND' | 'and' | 'And' | '&'  ;
OR 	
	:	'OR' | 'or' | 'Or' | '|' ;
XOR 	
	:	'XOR' | 'xor' ;
EQUAL 	
	:	'=' ;
NOT_EQUAL 
	:	'!=' ;
GREATER_THAN 
	:	'>' ; 
GREATER_THAN_OR_EQUAL 
	:	'>=' ;
LESS_THAN 
	:	'<' ;
LESS_THAN_OR_EQUAL 
	:	'<=' ;
FALSE 	
	:	'FALSE' | 'false' ;
TRUE 	
	:	'TRUE' | 'true' ;
UNKNOWN 
	:	'UNKNOWN' | 'unknown' ;
DIGIT 	
	:	'0'..'9' ;
INT 	
	:	'0'..'9'+;
HEX_DIGIT 
	:	DIGIT | ('a'..'f' | 'A'..'F') ;
LETTER 
	:	('a'..'z') | ('A'..'Z') ; 
SIMPLEID 
	:	LETTER ( LETTER | DIGIT | '_' )* ;    
LPAREN  
	:   	'(';
RPAREN  
	:   	')';  
OCTAL_ESC
	:   	'\\' ('0'..'3') ('0'..'7') ('0'..'7')   |   '\\' ('0'..'7') ('0'..'7')   |   '\\' ('0'..'7')  ;
UNICODE_ESC
	:   	'\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT ;
ESC_SEQ
    	:   	'\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')  |   UNICODE_ESC  |   OCTAL_ESC ;
STRING	
	:  	'\'' ( ESC_SEQ | ~('\\'|'\'') )* '\'';
WS 	
	:	(' '|'\t'|'\n'|'\r')+ { $channel = HIDDEN; } ;
	
