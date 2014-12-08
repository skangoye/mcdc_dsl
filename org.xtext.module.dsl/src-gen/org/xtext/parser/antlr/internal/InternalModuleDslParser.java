package org.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.services.ModuleDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalModuleDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IDENT", "RULE_BOOLEAN", "RULE_STRING", "RULE_ENUM_ELEMENT", "RULE_BIT", "RULE_HEX", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'{'", "'}'", "'@'", "'strategy'", "'interface'", "'body'", "'crit'", "':'", "';'", "'datasel'", "','", "'mcdc'", "'dc'", "'cc'", "'rand'", "'eqv'", "'bv'", "'in'", "'out'", "'inout'", "'const'", "'=='", "'init'", "'int'", "'real'", "'bool'", "'enum'", "'bit'", "'hex'", "'str'", "']'", "'['", "'..'", "'?'", "'if'", "'('", "')'", "'else'", "'loop'", "'error'", "'='", "'or'", "'and'", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'not'", "'.'"
    };
    public static final int T__68=68;
    public static final int RULE_BOOLEAN=5;
    public static final int T__69=69;
    public static final int RULE_ID=11;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int RULE_ENUM_ELEMENT=7;
    public static final int T__57=57;
    public static final int RULE_HEX=9;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_INT=10;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int RULE_IDENT=4;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;
    public static final int RULE_BIT=8;

    // delegates
    // delegators


        public InternalModuleDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModuleDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModuleDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g"; }



     	private ModuleDslGrammarAccess grammarAccess;
     	
        public InternalModuleDslParser(TokenStream input, ModuleDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "LANGUAGE";	
       	}
       	
       	@Override
       	protected ModuleDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLANGUAGE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:67:1: entryRuleLANGUAGE returns [EObject current=null] : iv_ruleLANGUAGE= ruleLANGUAGE EOF ;
    public final EObject entryRuleLANGUAGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLANGUAGE = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:68:2: (iv_ruleLANGUAGE= ruleLANGUAGE EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:69:2: iv_ruleLANGUAGE= ruleLANGUAGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLANGUAGERule()); 
            }
            pushFollow(FOLLOW_ruleLANGUAGE_in_entryRuleLANGUAGE75);
            iv_ruleLANGUAGE=ruleLANGUAGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLANGUAGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLANGUAGE85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLANGUAGE"


    // $ANTLR start "ruleLANGUAGE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:76:1: ruleLANGUAGE returns [EObject current=null] : ( (lv_modules_0_0= ruleMODULE_DECL ) )+ ;
    public final EObject ruleLANGUAGE() throws RecognitionException {
        EObject current = null;

        EObject lv_modules_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:79:28: ( ( (lv_modules_0_0= ruleMODULE_DECL ) )+ )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:80:1: ( (lv_modules_0_0= ruleMODULE_DECL ) )+
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:80:1: ( (lv_modules_0_0= ruleMODULE_DECL ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:81:1: (lv_modules_0_0= ruleMODULE_DECL )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:81:1: (lv_modules_0_0= ruleMODULE_DECL )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:82:3: lv_modules_0_0= ruleMODULE_DECL
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLANGUAGEAccess().getModulesMODULE_DECLParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMODULE_DECL_in_ruleLANGUAGE130);
            	    lv_modules_0_0=ruleMODULE_DECL();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLANGUAGERule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_0_0, 
            	              		"MODULE_DECL");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLANGUAGE"


    // $ANTLR start "entryRuleMODULE_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:106:1: entryRuleMODULE_DECL returns [EObject current=null] : iv_ruleMODULE_DECL= ruleMODULE_DECL EOF ;
    public final EObject entryRuleMODULE_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMODULE_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:107:2: (iv_ruleMODULE_DECL= ruleMODULE_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:108:2: iv_ruleMODULE_DECL= ruleMODULE_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMODULE_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleMODULE_DECL_in_entryRuleMODULE_DECL166);
            iv_ruleMODULE_DECL=ruleMODULE_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMODULE_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMODULE_DECL176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMODULE_DECL"


    // $ANTLR start "ruleMODULE_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:115:1: ruleMODULE_DECL returns [EObject current=null] : (otherlv_0= 'module' () ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= '{' ( (lv_strategy_4_0= ruleSTRATEGY ) ) ( (lv_interface_5_0= ruleINTERFACE ) ) ( (lv_body_6_0= ruleBODY ) ) otherlv_7= '}' ) ;
    public final EObject ruleMODULE_DECL() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_strategy_4_0 = null;

        EObject lv_interface_5_0 = null;

        EObject lv_body_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:118:28: ( (otherlv_0= 'module' () ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= '{' ( (lv_strategy_4_0= ruleSTRATEGY ) ) ( (lv_interface_5_0= ruleINTERFACE ) ) ( (lv_body_6_0= ruleBODY ) ) otherlv_7= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:119:1: (otherlv_0= 'module' () ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= '{' ( (lv_strategy_4_0= ruleSTRATEGY ) ) ( (lv_interface_5_0= ruleINTERFACE ) ) ( (lv_body_6_0= ruleBODY ) ) otherlv_7= '}' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:119:1: (otherlv_0= 'module' () ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= '{' ( (lv_strategy_4_0= ruleSTRATEGY ) ) ( (lv_interface_5_0= ruleINTERFACE ) ) ( (lv_body_6_0= ruleBODY ) ) otherlv_7= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:119:3: otherlv_0= 'module' () ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= '{' ( (lv_strategy_4_0= ruleSTRATEGY ) ) ( (lv_interface_5_0= ruleINTERFACE ) ) ( (lv_body_6_0= ruleBODY ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleMODULE_DECL213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMODULE_DECLAccess().getModuleKeyword_0());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:123:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:124:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMODULE_DECLAccess().getMODULE_DECLAction_1(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:129:2: ( (lv_name_2_0= RULE_IDENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:130:1: (lv_name_2_0= RULE_IDENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:130:1: (lv_name_2_0= RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:131:3: lv_name_2_0= RULE_IDENT
            {
            lv_name_2_0=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleMODULE_DECL239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getMODULE_DECLAccess().getNameIDENTTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMODULE_DECLRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"IDENT");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMODULE_DECL256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMODULE_DECLAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:151:1: ( (lv_strategy_4_0= ruleSTRATEGY ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:152:1: (lv_strategy_4_0= ruleSTRATEGY )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:152:1: (lv_strategy_4_0= ruleSTRATEGY )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:153:3: lv_strategy_4_0= ruleSTRATEGY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMODULE_DECLAccess().getStrategySTRATEGYParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSTRATEGY_in_ruleMODULE_DECL277);
            lv_strategy_4_0=ruleSTRATEGY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMODULE_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"strategy",
                      		lv_strategy_4_0, 
                      		"STRATEGY");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:169:2: ( (lv_interface_5_0= ruleINTERFACE ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:170:1: (lv_interface_5_0= ruleINTERFACE )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:170:1: (lv_interface_5_0= ruleINTERFACE )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:171:3: lv_interface_5_0= ruleINTERFACE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMODULE_DECLAccess().getInterfaceINTERFACEParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleINTERFACE_in_ruleMODULE_DECL298);
            lv_interface_5_0=ruleINTERFACE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMODULE_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"interface",
                      		lv_interface_5_0, 
                      		"INTERFACE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:187:2: ( (lv_body_6_0= ruleBODY ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:188:1: (lv_body_6_0= ruleBODY )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:188:1: (lv_body_6_0= ruleBODY )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:189:3: lv_body_6_0= ruleBODY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMODULE_DECLAccess().getBodyBODYParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBODY_in_ruleMODULE_DECL319);
            lv_body_6_0=ruleBODY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMODULE_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_6_0, 
                      		"BODY");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleMODULE_DECL331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMODULE_DECLAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMODULE_DECL"


    // $ANTLR start "entryRuleSTRATEGY"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:217:1: entryRuleSTRATEGY returns [EObject current=null] : iv_ruleSTRATEGY= ruleSTRATEGY EOF ;
    public final EObject entryRuleSTRATEGY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTRATEGY = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:218:2: (iv_ruleSTRATEGY= ruleSTRATEGY EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:219:2: iv_ruleSTRATEGY= ruleSTRATEGY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTRATEGYRule()); 
            }
            pushFollow(FOLLOW_ruleSTRATEGY_in_entryRuleSTRATEGY367);
            iv_ruleSTRATEGY=ruleSTRATEGY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTRATEGY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRATEGY377); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTRATEGY"


    // $ANTLR start "ruleSTRATEGY"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:226:1: ruleSTRATEGY returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'strategy' () otherlv_3= '{' ( (lv_critdecl_4_0= ruleCRITERION_DECL ) ) ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) ) otherlv_6= '}' ) ;
    public final EObject ruleSTRATEGY() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_critdecl_4_0 = null;

        EObject lv_dataseldecl_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:229:28: ( (otherlv_0= '@' otherlv_1= 'strategy' () otherlv_3= '{' ( (lv_critdecl_4_0= ruleCRITERION_DECL ) ) ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) ) otherlv_6= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:230:1: (otherlv_0= '@' otherlv_1= 'strategy' () otherlv_3= '{' ( (lv_critdecl_4_0= ruleCRITERION_DECL ) ) ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) ) otherlv_6= '}' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:230:1: (otherlv_0= '@' otherlv_1= 'strategy' () otherlv_3= '{' ( (lv_critdecl_4_0= ruleCRITERION_DECL ) ) ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) ) otherlv_6= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:230:3: otherlv_0= '@' otherlv_1= 'strategy' () otherlv_3= '{' ( (lv_critdecl_4_0= ruleCRITERION_DECL ) ) ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleSTRATEGY414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSTRATEGYAccess().getCommercialAtKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSTRATEGY426); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSTRATEGYAccess().getStrategyKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:238:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:239:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSTRATEGYAccess().getSTRATEGYAction_2(),
                          current);
                  
            }

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleSTRATEGY447); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSTRATEGYAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:248:1: ( (lv_critdecl_4_0= ruleCRITERION_DECL ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:249:1: (lv_critdecl_4_0= ruleCRITERION_DECL )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:249:1: (lv_critdecl_4_0= ruleCRITERION_DECL )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:250:3: lv_critdecl_4_0= ruleCRITERION_DECL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSTRATEGYAccess().getCritdeclCRITERION_DECLParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCRITERION_DECL_in_ruleSTRATEGY468);
            lv_critdecl_4_0=ruleCRITERION_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSTRATEGYRule());
              	        }
                     		set(
                     			current, 
                     			"critdecl",
                      		lv_critdecl_4_0, 
                      		"CRITERION_DECL");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:266:2: ( (lv_dataseldecl_5_0= ruleDATASEL_DECL ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:267:1: (lv_dataseldecl_5_0= ruleDATASEL_DECL )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:267:1: (lv_dataseldecl_5_0= ruleDATASEL_DECL )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:268:3: lv_dataseldecl_5_0= ruleDATASEL_DECL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSTRATEGYAccess().getDataseldeclDATASEL_DECLParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDATASEL_DECL_in_ruleSTRATEGY489);
            lv_dataseldecl_5_0=ruleDATASEL_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSTRATEGYRule());
              	        }
                     		set(
                     			current, 
                     			"dataseldecl",
                      		lv_dataseldecl_5_0, 
                      		"DATASEL_DECL");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleSTRATEGY501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getSTRATEGYAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTRATEGY"


    // $ANTLR start "entryRuleINTERFACE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:296:1: entryRuleINTERFACE returns [EObject current=null] : iv_ruleINTERFACE= ruleINTERFACE EOF ;
    public final EObject entryRuleINTERFACE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleINTERFACE = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:297:2: (iv_ruleINTERFACE= ruleINTERFACE EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:298:2: iv_ruleINTERFACE= ruleINTERFACE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTERFACERule()); 
            }
            pushFollow(FOLLOW_ruleINTERFACE_in_entryRuleINTERFACE537);
            iv_ruleINTERFACE=ruleINTERFACE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTERFACE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTERFACE547); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTERFACE"


    // $ANTLR start "ruleINTERFACE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:305:1: ruleINTERFACE returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'interface' () otherlv_3= '{' ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+ otherlv_5= '}' ) ;
    public final EObject ruleINTERFACE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_declaration_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:308:28: ( (otherlv_0= '@' otherlv_1= 'interface' () otherlv_3= '{' ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+ otherlv_5= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:309:1: (otherlv_0= '@' otherlv_1= 'interface' () otherlv_3= '{' ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+ otherlv_5= '}' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:309:1: (otherlv_0= '@' otherlv_1= 'interface' () otherlv_3= '{' ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+ otherlv_5= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:309:3: otherlv_0= '@' otherlv_1= 'interface' () otherlv_3= '{' ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleINTERFACE584); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getINTERFACEAccess().getCommercialAtKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleINTERFACE596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getINTERFACEAccess().getInterfaceKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:317:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:318:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getINTERFACEAccess().getINTERFACEAction_2(),
                          current);
                  
            }

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleINTERFACE617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getINTERFACEAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:327:1: ( (lv_declaration_4_0= ruleAbstractVAR_DECL ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=34 && LA2_0<=37)||(LA2_0>=40 && LA2_0<=46)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:328:1: (lv_declaration_4_0= ruleAbstractVAR_DECL )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:328:1: (lv_declaration_4_0= ruleAbstractVAR_DECL )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:329:3: lv_declaration_4_0= ruleAbstractVAR_DECL
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getINTERFACEAccess().getDeclarationAbstractVAR_DECLParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractVAR_DECL_in_ruleINTERFACE638);
            	    lv_declaration_4_0=ruleAbstractVAR_DECL();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getINTERFACERule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"declaration",
            	              		lv_declaration_4_0, 
            	              		"AbstractVAR_DECL");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleINTERFACE651); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getINTERFACEAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTERFACE"


    // $ANTLR start "entryRuleBODY"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:357:1: entryRuleBODY returns [EObject current=null] : iv_ruleBODY= ruleBODY EOF ;
    public final EObject entryRuleBODY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBODY = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:358:2: (iv_ruleBODY= ruleBODY EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:359:2: iv_ruleBODY= ruleBODY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBODYRule()); 
            }
            pushFollow(FOLLOW_ruleBODY_in_entryRuleBODY687);
            iv_ruleBODY=ruleBODY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBODY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBODY697); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBODY"


    // $ANTLR start "ruleBODY"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:366:1: ruleBODY returns [EObject current=null] : (otherlv_0= '@' otherlv_1= 'body' () otherlv_3= '{' ( (lv_statements_4_0= ruleSTATEMENT ) )* otherlv_5= '}' ) ;
    public final EObject ruleBODY() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:369:28: ( (otherlv_0= '@' otherlv_1= 'body' () otherlv_3= '{' ( (lv_statements_4_0= ruleSTATEMENT ) )* otherlv_5= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:370:1: (otherlv_0= '@' otherlv_1= 'body' () otherlv_3= '{' ( (lv_statements_4_0= ruleSTATEMENT ) )* otherlv_5= '}' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:370:1: (otherlv_0= '@' otherlv_1= 'body' () otherlv_3= '{' ( (lv_statements_4_0= ruleSTATEMENT ) )* otherlv_5= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:370:3: otherlv_0= '@' otherlv_1= 'body' () otherlv_3= '{' ( (lv_statements_4_0= ruleSTATEMENT ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleBODY734); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBODYAccess().getCommercialAtKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleBODY746); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBODYAccess().getBodyKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:378:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:379:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBODYAccess().getBODYAction_2(),
                          current);
                  
            }

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleBODY767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBODYAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:388:1: ( (lv_statements_4_0= ruleSTATEMENT ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_IDENT||(LA3_0>=34 && LA3_0<=37)||(LA3_0>=40 && LA3_0<=46)||LA3_0==51||(LA3_0>=55 && LA3_0<=56)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:389:1: (lv_statements_4_0= ruleSTATEMENT )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:389:1: (lv_statements_4_0= ruleSTATEMENT )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:390:3: lv_statements_4_0= ruleSTATEMENT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBODYAccess().getStatementsSTATEMENTParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSTATEMENT_in_ruleBODY788);
            	    lv_statements_4_0=ruleSTATEMENT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBODYRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_4_0, 
            	              		"STATEMENT");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleBODY801); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getBODYAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBODY"


    // $ANTLR start "entryRuleCRITERION_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:418:1: entryRuleCRITERION_DECL returns [EObject current=null] : iv_ruleCRITERION_DECL= ruleCRITERION_DECL EOF ;
    public final EObject entryRuleCRITERION_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCRITERION_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:419:2: (iv_ruleCRITERION_DECL= ruleCRITERION_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:420:2: iv_ruleCRITERION_DECL= ruleCRITERION_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCRITERION_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleCRITERION_DECL_in_entryRuleCRITERION_DECL837);
            iv_ruleCRITERION_DECL=ruleCRITERION_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCRITERION_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCRITERION_DECL847); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCRITERION_DECL"


    // $ANTLR start "ruleCRITERION_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:427:1: ruleCRITERION_DECL returns [EObject current=null] : (otherlv_0= 'crit' otherlv_1= ':' () ( (lv_crit_3_0= ruleCRITERION ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleCRITERION_DECL() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_crit_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:430:28: ( (otherlv_0= 'crit' otherlv_1= ':' () ( (lv_crit_3_0= ruleCRITERION ) ) (otherlv_4= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:431:1: (otherlv_0= 'crit' otherlv_1= ':' () ( (lv_crit_3_0= ruleCRITERION ) ) (otherlv_4= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:431:1: (otherlv_0= 'crit' otherlv_1= ':' () ( (lv_crit_3_0= ruleCRITERION ) ) (otherlv_4= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:431:3: otherlv_0= 'crit' otherlv_1= ':' () ( (lv_crit_3_0= ruleCRITERION ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleCRITERION_DECL884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCRITERION_DECLAccess().getCritKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleCRITERION_DECL896); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCRITERION_DECLAccess().getColonKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:439:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:440:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCRITERION_DECLAccess().getCRITERION_DECLAction_2(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:445:2: ( (lv_crit_3_0= ruleCRITERION ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:446:1: (lv_crit_3_0= ruleCRITERION )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:446:1: (lv_crit_3_0= ruleCRITERION )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:447:3: lv_crit_3_0= ruleCRITERION
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCRITERION_DECLAccess().getCritCRITERIONParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCRITERION_in_ruleCRITERION_DECL926);
            lv_crit_3_0=ruleCRITERION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCRITERION_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"crit",
                      		lv_crit_3_0, 
                      		"CRITERION");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:463:2: (otherlv_4= ';' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==25) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:463:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleCRITERION_DECL939); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCRITERION_DECLAccess().getSemicolonKeyword_4());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCRITERION_DECL"


    // $ANTLR start "entryRuleDATASEL_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:475:1: entryRuleDATASEL_DECL returns [EObject current=null] : iv_ruleDATASEL_DECL= ruleDATASEL_DECL EOF ;
    public final EObject entryRuleDATASEL_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDATASEL_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:476:2: (iv_ruleDATASEL_DECL= ruleDATASEL_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:477:2: iv_ruleDATASEL_DECL= ruleDATASEL_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDATASEL_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleDATASEL_DECL_in_entryRuleDATASEL_DECL977);
            iv_ruleDATASEL_DECL=ruleDATASEL_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDATASEL_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDATASEL_DECL987); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDATASEL_DECL"


    // $ANTLR start "ruleDATASEL_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:484:1: ruleDATASEL_DECL returns [EObject current=null] : (otherlv_0= 'datasel' otherlv_1= ':' () ( (lv_data1_3_0= ruleDATASEL ) ) (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )? (otherlv_6= ';' )? ) ;
    public final EObject ruleDATASEL_DECL() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_data1_3_0 = null;

        EObject lv_data2_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:487:28: ( (otherlv_0= 'datasel' otherlv_1= ':' () ( (lv_data1_3_0= ruleDATASEL ) ) (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )? (otherlv_6= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:488:1: (otherlv_0= 'datasel' otherlv_1= ':' () ( (lv_data1_3_0= ruleDATASEL ) ) (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )? (otherlv_6= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:488:1: (otherlv_0= 'datasel' otherlv_1= ':' () ( (lv_data1_3_0= ruleDATASEL ) ) (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )? (otherlv_6= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:488:3: otherlv_0= 'datasel' otherlv_1= ':' () ( (lv_data1_3_0= ruleDATASEL ) ) (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )? (otherlv_6= ';' )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleDATASEL_DECL1024); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDATASEL_DECLAccess().getDataselKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleDATASEL_DECL1036); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDATASEL_DECLAccess().getColonKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:496:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:497:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDATASEL_DECLAccess().getDATASEL_DECLAction_2(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:502:2: ( (lv_data1_3_0= ruleDATASEL ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:503:1: (lv_data1_3_0= ruleDATASEL )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:503:1: (lv_data1_3_0= ruleDATASEL )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:504:3: lv_data1_3_0= ruleDATASEL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDATASEL_DECLAccess().getData1DATASELParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDATASEL_in_ruleDATASEL_DECL1066);
            lv_data1_3_0=ruleDATASEL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDATASEL_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"data1",
                      		lv_data1_3_0, 
                      		"DATASEL");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:520:2: (otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:520:4: otherlv_4= ',' ( (lv_data2_5_0= ruleDATASEL ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleDATASEL_DECL1079); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDATASEL_DECLAccess().getCommaKeyword_4_0());
                          
                    }
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:524:1: ( (lv_data2_5_0= ruleDATASEL ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:525:1: (lv_data2_5_0= ruleDATASEL )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:525:1: (lv_data2_5_0= ruleDATASEL )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:526:3: lv_data2_5_0= ruleDATASEL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDATASEL_DECLAccess().getData2DATASELParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDATASEL_in_ruleDATASEL_DECL1100);
                    lv_data2_5_0=ruleDATASEL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDATASEL_DECLRule());
                      	        }
                             		set(
                             			current, 
                             			"data2",
                              		lv_data2_5_0, 
                              		"DATASEL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:542:4: (otherlv_6= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:542:6: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleDATASEL_DECL1115); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDATASEL_DECLAccess().getSemicolonKeyword_5());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDATASEL_DECL"


    // $ANTLR start "entryRuleCRITERION"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:554:1: entryRuleCRITERION returns [EObject current=null] : iv_ruleCRITERION= ruleCRITERION EOF ;
    public final EObject entryRuleCRITERION() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCRITERION = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:555:2: (iv_ruleCRITERION= ruleCRITERION EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:556:2: iv_ruleCRITERION= ruleCRITERION EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCRITERIONRule()); 
            }
            pushFollow(FOLLOW_ruleCRITERION_in_entryRuleCRITERION1153);
            iv_ruleCRITERION=ruleCRITERION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCRITERION; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCRITERION1163); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCRITERION"


    // $ANTLR start "ruleCRITERION"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:563:1: ruleCRITERION returns [EObject current=null] : ( ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) ) ) ;
    public final EObject ruleCRITERION() throws RecognitionException {
        EObject current = null;

        Token lv_crit_0_1=null;
        Token lv_crit_0_2=null;
        Token lv_crit_0_3=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:566:28: ( ( ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:567:1: ( ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:567:1: ( ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:568:1: ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:568:1: ( (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:569:1: (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:569:1: (lv_crit_0_1= 'mcdc' | lv_crit_0_2= 'dc' | lv_crit_0_3= 'cc' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt7=1;
                }
                break;
            case 29:
                {
                alt7=2;
                }
                break;
            case 30:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:570:3: lv_crit_0_1= 'mcdc'
                    {
                    lv_crit_0_1=(Token)match(input,28,FOLLOW_28_in_ruleCRITERION1207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_crit_0_1, grammarAccess.getCRITERIONAccess().getCritMcdcKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCRITERIONRule());
                      	        }
                             		setWithLastConsumed(current, "crit", lv_crit_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:582:8: lv_crit_0_2= 'dc'
                    {
                    lv_crit_0_2=(Token)match(input,29,FOLLOW_29_in_ruleCRITERION1236); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_crit_0_2, grammarAccess.getCRITERIONAccess().getCritDcKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCRITERIONRule());
                      	        }
                             		setWithLastConsumed(current, "crit", lv_crit_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:594:8: lv_crit_0_3= 'cc'
                    {
                    lv_crit_0_3=(Token)match(input,30,FOLLOW_30_in_ruleCRITERION1265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_crit_0_3, grammarAccess.getCRITERIONAccess().getCritCcKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCRITERIONRule());
                      	        }
                             		setWithLastConsumed(current, "crit", lv_crit_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCRITERION"


    // $ANTLR start "entryRuleDATASEL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:617:1: entryRuleDATASEL returns [EObject current=null] : iv_ruleDATASEL= ruleDATASEL EOF ;
    public final EObject entryRuleDATASEL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDATASEL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:618:2: (iv_ruleDATASEL= ruleDATASEL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:619:2: iv_ruleDATASEL= ruleDATASEL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDATASELRule()); 
            }
            pushFollow(FOLLOW_ruleDATASEL_in_entryRuleDATASEL1316);
            iv_ruleDATASEL=ruleDATASEL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDATASEL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDATASEL1326); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDATASEL"


    // $ANTLR start "ruleDATASEL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:626:1: ruleDATASEL returns [EObject current=null] : ( ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) ) ) ;
    public final EObject ruleDATASEL() throws RecognitionException {
        EObject current = null;

        Token lv_sel_0_1=null;
        Token lv_sel_0_2=null;
        Token lv_sel_0_3=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:629:28: ( ( ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:630:1: ( ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:630:1: ( ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:631:1: ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:631:1: ( (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:632:1: (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:632:1: (lv_sel_0_1= 'rand' | lv_sel_0_2= 'eqv' | lv_sel_0_3= 'bv' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt8=1;
                }
                break;
            case 32:
                {
                alt8=2;
                }
                break;
            case 33:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:633:3: lv_sel_0_1= 'rand'
                    {
                    lv_sel_0_1=(Token)match(input,31,FOLLOW_31_in_ruleDATASEL1370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sel_0_1, grammarAccess.getDATASELAccess().getSelRandKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDATASELRule());
                      	        }
                             		setWithLastConsumed(current, "sel", lv_sel_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:645:8: lv_sel_0_2= 'eqv'
                    {
                    lv_sel_0_2=(Token)match(input,32,FOLLOW_32_in_ruleDATASEL1399); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sel_0_2, grammarAccess.getDATASELAccess().getSelEqvKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDATASELRule());
                      	        }
                             		setWithLastConsumed(current, "sel", lv_sel_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:657:8: lv_sel_0_3= 'bv'
                    {
                    lv_sel_0_3=(Token)match(input,33,FOLLOW_33_in_ruleDATASEL1428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sel_0_3, grammarAccess.getDATASELAccess().getSelBvKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDATASELRule());
                      	        }
                             		setWithLastConsumed(current, "sel", lv_sel_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDATASEL"


    // $ANTLR start "entryRuleAbstractVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:680:1: entryRuleAbstractVAR_DECL returns [EObject current=null] : iv_ruleAbstractVAR_DECL= ruleAbstractVAR_DECL EOF ;
    public final EObject entryRuleAbstractVAR_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractVAR_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:681:2: (iv_ruleAbstractVAR_DECL= ruleAbstractVAR_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:682:2: iv_ruleAbstractVAR_DECL= ruleAbstractVAR_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractVAR_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleAbstractVAR_DECL_in_entryRuleAbstractVAR_DECL1479);
            iv_ruleAbstractVAR_DECL=ruleAbstractVAR_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractVAR_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractVAR_DECL1489); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractVAR_DECL"


    // $ANTLR start "ruleAbstractVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:689:1: ruleAbstractVAR_DECL returns [EObject current=null] : (this_VAR_DECL_0= ruleVAR_DECL | this_TmpVAR_DECL_1= ruleTmpVAR_DECL | this_CST_DECL_2= ruleCST_DECL ) ;
    public final EObject ruleAbstractVAR_DECL() throws RecognitionException {
        EObject current = null;

        EObject this_VAR_DECL_0 = null;

        EObject this_TmpVAR_DECL_1 = null;

        EObject this_CST_DECL_2 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:692:28: ( (this_VAR_DECL_0= ruleVAR_DECL | this_TmpVAR_DECL_1= ruleTmpVAR_DECL | this_CST_DECL_2= ruleCST_DECL ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:693:1: (this_VAR_DECL_0= ruleVAR_DECL | this_TmpVAR_DECL_1= ruleTmpVAR_DECL | this_CST_DECL_2= ruleCST_DECL )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:693:1: (this_VAR_DECL_0= ruleVAR_DECL | this_TmpVAR_DECL_1= ruleTmpVAR_DECL | this_CST_DECL_2= ruleCST_DECL )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 34:
            case 35:
            case 36:
                {
                alt9=1;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt9=2;
                }
                break;
            case 37:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:694:5: this_VAR_DECL_0= ruleVAR_DECL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractVAR_DECLAccess().getVAR_DECLParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVAR_DECL_in_ruleAbstractVAR_DECL1536);
                    this_VAR_DECL_0=ruleVAR_DECL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_VAR_DECL_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:704:5: this_TmpVAR_DECL_1= ruleTmpVAR_DECL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractVAR_DECLAccess().getTmpVAR_DECLParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTmpVAR_DECL_in_ruleAbstractVAR_DECL1563);
                    this_TmpVAR_DECL_1=ruleTmpVAR_DECL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TmpVAR_DECL_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:714:5: this_CST_DECL_2= ruleCST_DECL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractVAR_DECLAccess().getCST_DECLParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCST_DECL_in_ruleAbstractVAR_DECL1590);
                    this_CST_DECL_2=ruleCST_DECL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CST_DECL_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractVAR_DECL"


    // $ANTLR start "entryRuleVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:730:1: entryRuleVAR_DECL returns [EObject current=null] : iv_ruleVAR_DECL= ruleVAR_DECL EOF ;
    public final EObject entryRuleVAR_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVAR_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:731:2: (iv_ruleVAR_DECL= ruleVAR_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:732:2: iv_ruleVAR_DECL= ruleVAR_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVAR_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleVAR_DECL_in_entryRuleVAR_DECL1625);
            iv_ruleVAR_DECL=ruleVAR_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVAR_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVAR_DECL1635); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVAR_DECL"


    // $ANTLR start "ruleVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:739:1: ruleVAR_DECL returns [EObject current=null] : ( () ( (lv_flow_1_0= ruleFlow ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= ':' ( (lv_type_4_0= ruleTYPE ) ) ( (lv_range_5_0= ruleRANGE ) )? (otherlv_6= ';' )? ) ;
    public final EObject ruleVAR_DECL() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_flow_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_range_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:742:28: ( ( () ( (lv_flow_1_0= ruleFlow ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= ':' ( (lv_type_4_0= ruleTYPE ) ) ( (lv_range_5_0= ruleRANGE ) )? (otherlv_6= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:743:1: ( () ( (lv_flow_1_0= ruleFlow ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= ':' ( (lv_type_4_0= ruleTYPE ) ) ( (lv_range_5_0= ruleRANGE ) )? (otherlv_6= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:743:1: ( () ( (lv_flow_1_0= ruleFlow ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= ':' ( (lv_type_4_0= ruleTYPE ) ) ( (lv_range_5_0= ruleRANGE ) )? (otherlv_6= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:743:2: () ( (lv_flow_1_0= ruleFlow ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= ':' ( (lv_type_4_0= ruleTYPE ) ) ( (lv_range_5_0= ruleRANGE ) )? (otherlv_6= ';' )?
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:743:2: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:744:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVAR_DECLAccess().getVAR_DECLAction_0(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:749:2: ( (lv_flow_1_0= ruleFlow ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:750:1: (lv_flow_1_0= ruleFlow )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:750:1: (lv_flow_1_0= ruleFlow )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:751:3: lv_flow_1_0= ruleFlow
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVAR_DECLAccess().getFlowFlowParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlow_in_ruleVAR_DECL1690);
            lv_flow_1_0=ruleFlow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVAR_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"flow",
                      		lv_flow_1_0, 
                      		"Flow");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:767:2: ( (lv_name_2_0= RULE_IDENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:768:1: (lv_name_2_0= RULE_IDENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:768:1: (lv_name_2_0= RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:769:3: lv_name_2_0= RULE_IDENT
            {
            lv_name_2_0=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleVAR_DECL1707); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getVAR_DECLAccess().getNameIDENTTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVAR_DECLRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"IDENT");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleVAR_DECL1724); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getVAR_DECLAccess().getColonKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:789:1: ( (lv_type_4_0= ruleTYPE ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:790:1: (lv_type_4_0= ruleTYPE )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:790:1: (lv_type_4_0= ruleTYPE )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:791:3: lv_type_4_0= ruleTYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVAR_DECLAccess().getTypeTYPEParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTYPE_in_ruleVAR_DECL1745);
            lv_type_4_0=ruleTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVAR_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_4_0, 
                      		"TYPE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:807:2: ( (lv_range_5_0= ruleRANGE ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17||(LA10_0>=47 && LA10_0<=48)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:808:1: (lv_range_5_0= ruleRANGE )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:808:1: (lv_range_5_0= ruleRANGE )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:809:3: lv_range_5_0= ruleRANGE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVAR_DECLAccess().getRangeRANGEParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRANGE_in_ruleVAR_DECL1766);
                    lv_range_5_0=ruleRANGE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVAR_DECLRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_5_0, 
                              		"RANGE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:825:3: (otherlv_6= ';' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:825:5: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleVAR_DECL1780); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getVAR_DECLAccess().getSemicolonKeyword_6());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVAR_DECL"


    // $ANTLR start "entryRuleFlow"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:837:1: entryRuleFlow returns [EObject current=null] : iv_ruleFlow= ruleFlow EOF ;
    public final EObject entryRuleFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlow = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:838:2: (iv_ruleFlow= ruleFlow EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:839:2: iv_ruleFlow= ruleFlow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowRule()); 
            }
            pushFollow(FOLLOW_ruleFlow_in_entryRuleFlow1818);
            iv_ruleFlow=ruleFlow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlow1828); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlow"


    // $ANTLR start "ruleFlow"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:846:1: ruleFlow returns [EObject current=null] : ( ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) ) ) ;
    public final EObject ruleFlow() throws RecognitionException {
        EObject current = null;

        Token lv_flow_0_1=null;
        Token lv_flow_0_2=null;
        Token lv_flow_0_3=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:849:28: ( ( ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:850:1: ( ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:850:1: ( ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:851:1: ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:851:1: ( (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:852:1: (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:852:1: (lv_flow_0_1= 'in' | lv_flow_0_2= 'out' | lv_flow_0_3= 'inout' )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt12=1;
                }
                break;
            case 35:
                {
                alt12=2;
                }
                break;
            case 36:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:853:3: lv_flow_0_1= 'in'
                    {
                    lv_flow_0_1=(Token)match(input,34,FOLLOW_34_in_ruleFlow1872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_flow_0_1, grammarAccess.getFlowAccess().getFlowInKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowRule());
                      	        }
                             		setWithLastConsumed(current, "flow", lv_flow_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:865:8: lv_flow_0_2= 'out'
                    {
                    lv_flow_0_2=(Token)match(input,35,FOLLOW_35_in_ruleFlow1901); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_flow_0_2, grammarAccess.getFlowAccess().getFlowOutKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowRule());
                      	        }
                             		setWithLastConsumed(current, "flow", lv_flow_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:877:8: lv_flow_0_3= 'inout'
                    {
                    lv_flow_0_3=(Token)match(input,36,FOLLOW_36_in_ruleFlow1930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_flow_0_3, grammarAccess.getFlowAccess().getFlowInoutKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowRule());
                      	        }
                             		setWithLastConsumed(current, "flow", lv_flow_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlow"


    // $ANTLR start "entryRuleCST_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:900:1: entryRuleCST_DECL returns [EObject current=null] : iv_ruleCST_DECL= ruleCST_DECL EOF ;
    public final EObject entryRuleCST_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCST_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:901:2: (iv_ruleCST_DECL= ruleCST_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:902:2: iv_ruleCST_DECL= ruleCST_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCST_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleCST_DECL_in_entryRuleCST_DECL1981);
            iv_ruleCST_DECL=ruleCST_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCST_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCST_DECL1991); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCST_DECL"


    // $ANTLR start "ruleCST_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:909:1: ruleCST_DECL returns [EObject current=null] : ( () ( (lv_flow_1_0= 'const' ) ) ( (lv_type_2_0= ruleTYPE ) ) ( (lv_name_3_0= RULE_IDENT ) ) otherlv_4= '==' ( (lv_value_5_0= ruleLiteral ) ) (otherlv_6= ';' )? ) ;
    public final EObject ruleCST_DECL() throws RecognitionException {
        EObject current = null;

        Token lv_flow_1_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_type_2_0 = null;

        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:912:28: ( ( () ( (lv_flow_1_0= 'const' ) ) ( (lv_type_2_0= ruleTYPE ) ) ( (lv_name_3_0= RULE_IDENT ) ) otherlv_4= '==' ( (lv_value_5_0= ruleLiteral ) ) (otherlv_6= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:913:1: ( () ( (lv_flow_1_0= 'const' ) ) ( (lv_type_2_0= ruleTYPE ) ) ( (lv_name_3_0= RULE_IDENT ) ) otherlv_4= '==' ( (lv_value_5_0= ruleLiteral ) ) (otherlv_6= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:913:1: ( () ( (lv_flow_1_0= 'const' ) ) ( (lv_type_2_0= ruleTYPE ) ) ( (lv_name_3_0= RULE_IDENT ) ) otherlv_4= '==' ( (lv_value_5_0= ruleLiteral ) ) (otherlv_6= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:913:2: () ( (lv_flow_1_0= 'const' ) ) ( (lv_type_2_0= ruleTYPE ) ) ( (lv_name_3_0= RULE_IDENT ) ) otherlv_4= '==' ( (lv_value_5_0= ruleLiteral ) ) (otherlv_6= ';' )?
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:913:2: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:914:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCST_DECLAccess().getCST_DECLAction_0(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:919:2: ( (lv_flow_1_0= 'const' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:920:1: (lv_flow_1_0= 'const' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:920:1: (lv_flow_1_0= 'const' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:921:3: lv_flow_1_0= 'const'
            {
            lv_flow_1_0=(Token)match(input,37,FOLLOW_37_in_ruleCST_DECL2043); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_flow_1_0, grammarAccess.getCST_DECLAccess().getFlowConstKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCST_DECLRule());
              	        }
                     		setWithLastConsumed(current, "flow", lv_flow_1_0, "const");
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:934:2: ( (lv_type_2_0= ruleTYPE ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:935:1: (lv_type_2_0= ruleTYPE )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:935:1: (lv_type_2_0= ruleTYPE )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:936:3: lv_type_2_0= ruleTYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCST_DECLAccess().getTypeTYPEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTYPE_in_ruleCST_DECL2077);
            lv_type_2_0=ruleTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCST_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"TYPE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:952:2: ( (lv_name_3_0= RULE_IDENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:953:1: (lv_name_3_0= RULE_IDENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:953:1: (lv_name_3_0= RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:954:3: lv_name_3_0= RULE_IDENT
            {
            lv_name_3_0=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleCST_DECL2094); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getCST_DECLAccess().getNameIDENTTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCST_DECLRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"IDENT");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleCST_DECL2111); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCST_DECLAccess().getEqualsSignEqualsSignKeyword_4());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:974:1: ( (lv_value_5_0= ruleLiteral ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:975:1: (lv_value_5_0= ruleLiteral )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:975:1: (lv_value_5_0= ruleLiteral )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:976:3: lv_value_5_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCST_DECLAccess().getValueLiteralParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleCST_DECL2132);
            lv_value_5_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCST_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_5_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:992:2: (otherlv_6= ';' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:992:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleCST_DECL2145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCST_DECLAccess().getSemicolonKeyword_6());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCST_DECL"


    // $ANTLR start "entryRuleTmpVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1004:1: entryRuleTmpVAR_DECL returns [EObject current=null] : iv_ruleTmpVAR_DECL= ruleTmpVAR_DECL EOF ;
    public final EObject entryRuleTmpVAR_DECL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmpVAR_DECL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1005:2: (iv_ruleTmpVAR_DECL= ruleTmpVAR_DECL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1006:2: iv_ruleTmpVAR_DECL= ruleTmpVAR_DECL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTmpVAR_DECLRule()); 
            }
            pushFollow(FOLLOW_ruleTmpVAR_DECL_in_entryRuleTmpVAR_DECL2183);
            iv_ruleTmpVAR_DECL=ruleTmpVAR_DECL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTmpVAR_DECL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTmpVAR_DECL2193); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTmpVAR_DECL"


    // $ANTLR start "ruleTmpVAR_DECL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1013:1: ruleTmpVAR_DECL returns [EObject current=null] : ( () ( (lv_type_1_0= ruleTYPE ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= 'init' ( (lv_value_4_0= ruleEXPRESSION ) ) (otherlv_5= ';' )? ) ;
    public final EObject ruleTmpVAR_DECL() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1016:28: ( ( () ( (lv_type_1_0= ruleTYPE ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= 'init' ( (lv_value_4_0= ruleEXPRESSION ) ) (otherlv_5= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1017:1: ( () ( (lv_type_1_0= ruleTYPE ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= 'init' ( (lv_value_4_0= ruleEXPRESSION ) ) (otherlv_5= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1017:1: ( () ( (lv_type_1_0= ruleTYPE ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= 'init' ( (lv_value_4_0= ruleEXPRESSION ) ) (otherlv_5= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1017:2: () ( (lv_type_1_0= ruleTYPE ) ) ( (lv_name_2_0= RULE_IDENT ) ) otherlv_3= 'init' ( (lv_value_4_0= ruleEXPRESSION ) ) (otherlv_5= ';' )?
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1017:2: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1018:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getTmpVAR_DECLAccess().getTmpVAR_DECLAction_0(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1023:2: ( (lv_type_1_0= ruleTYPE ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1024:1: (lv_type_1_0= ruleTYPE )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1024:1: (lv_type_1_0= ruleTYPE )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1025:3: lv_type_1_0= ruleTYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTmpVAR_DECLAccess().getTypeTYPEParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTYPE_in_ruleTmpVAR_DECL2248);
            lv_type_1_0=ruleTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTmpVAR_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"TYPE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1041:2: ( (lv_name_2_0= RULE_IDENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1042:1: (lv_name_2_0= RULE_IDENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1042:1: (lv_name_2_0= RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1043:3: lv_name_2_0= RULE_IDENT
            {
            lv_name_2_0=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleTmpVAR_DECL2265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getTmpVAR_DECLAccess().getNameIDENTTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTmpVAR_DECLRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"IDENT");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleTmpVAR_DECL2282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTmpVAR_DECLAccess().getInitKeyword_3());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1063:1: ( (lv_value_4_0= ruleEXPRESSION ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1064:1: (lv_value_4_0= ruleEXPRESSION )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1064:1: (lv_value_4_0= ruleEXPRESSION )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1065:3: lv_value_4_0= ruleEXPRESSION
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTmpVAR_DECLAccess().getValueEXPRESSIONParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEXPRESSION_in_ruleTmpVAR_DECL2303);
            lv_value_4_0=ruleEXPRESSION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTmpVAR_DECLRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_4_0, 
                      		"EXPRESSION");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1081:2: (otherlv_5= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1081:4: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleTmpVAR_DECL2316); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTmpVAR_DECLAccess().getSemicolonKeyword_5());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTmpVAR_DECL"


    // $ANTLR start "entryRuleTYPE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1093:1: entryRuleTYPE returns [EObject current=null] : iv_ruleTYPE= ruleTYPE EOF ;
    public final EObject entryRuleTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTYPE = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1094:2: (iv_ruleTYPE= ruleTYPE EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1095:2: iv_ruleTYPE= ruleTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTYPERule()); 
            }
            pushFollow(FOLLOW_ruleTYPE_in_entryRuleTYPE2354);
            iv_ruleTYPE=ruleTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTYPE2364); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTYPE"


    // $ANTLR start "ruleTYPE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1102:1: ruleTYPE returns [EObject current=null] : ( ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) ) ) ;
    public final EObject ruleTYPE() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;
        Token lv_type_0_5=null;
        Token lv_type_0_6=null;
        Token lv_type_0_7=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1105:28: ( ( ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1106:1: ( ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1106:1: ( ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1107:1: ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1107:1: ( (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1108:1: (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1108:1: (lv_type_0_1= 'int' | lv_type_0_2= 'real' | lv_type_0_3= 'bool' | lv_type_0_4= 'enum' | lv_type_0_5= 'bit' | lv_type_0_6= 'hex' | lv_type_0_7= 'str' )
            int alt15=7;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt15=1;
                }
                break;
            case 41:
                {
                alt15=2;
                }
                break;
            case 42:
                {
                alt15=3;
                }
                break;
            case 43:
                {
                alt15=4;
                }
                break;
            case 44:
                {
                alt15=5;
                }
                break;
            case 45:
                {
                alt15=6;
                }
                break;
            case 46:
                {
                alt15=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1109:3: lv_type_0_1= 'int'
                    {
                    lv_type_0_1=(Token)match(input,40,FOLLOW_40_in_ruleTYPE2408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_1, grammarAccess.getTYPEAccess().getTypeIntKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1121:8: lv_type_0_2= 'real'
                    {
                    lv_type_0_2=(Token)match(input,41,FOLLOW_41_in_ruleTYPE2437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_2, grammarAccess.getTYPEAccess().getTypeRealKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1133:8: lv_type_0_3= 'bool'
                    {
                    lv_type_0_3=(Token)match(input,42,FOLLOW_42_in_ruleTYPE2466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_3, grammarAccess.getTYPEAccess().getTypeBoolKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_3, null);
                      	    
                    }

                    }
                    break;
                case 4 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1145:8: lv_type_0_4= 'enum'
                    {
                    lv_type_0_4=(Token)match(input,43,FOLLOW_43_in_ruleTYPE2495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_4, grammarAccess.getTYPEAccess().getTypeEnumKeyword_0_3());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_4, null);
                      	    
                    }

                    }
                    break;
                case 5 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1157:8: lv_type_0_5= 'bit'
                    {
                    lv_type_0_5=(Token)match(input,44,FOLLOW_44_in_ruleTYPE2524); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_5, grammarAccess.getTYPEAccess().getTypeBitKeyword_0_4());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_5, null);
                      	    
                    }

                    }
                    break;
                case 6 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1169:8: lv_type_0_6= 'hex'
                    {
                    lv_type_0_6=(Token)match(input,45,FOLLOW_45_in_ruleTYPE2553); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_6, grammarAccess.getTYPEAccess().getTypeHexKeyword_0_5());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_6, null);
                      	    
                    }

                    }
                    break;
                case 7 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1181:8: lv_type_0_7= 'str'
                    {
                    lv_type_0_7=(Token)match(input,46,FOLLOW_46_in_ruleTYPE2582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_7, grammarAccess.getTYPEAccess().getTypeStrKeyword_0_6());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTYPERule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_7, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTYPE"


    // $ANTLR start "entryRuleRANGE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1204:1: entryRuleRANGE returns [EObject current=null] : iv_ruleRANGE= ruleRANGE EOF ;
    public final EObject entryRuleRANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRANGE = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1205:2: (iv_ruleRANGE= ruleRANGE EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1206:2: iv_ruleRANGE= ruleRANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRANGERule()); 
            }
            pushFollow(FOLLOW_ruleRANGE_in_entryRuleRANGE2633);
            iv_ruleRANGE=ruleRANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRANGE2643); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRANGE"


    // $ANTLR start "ruleRANGE"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1213:1: ruleRANGE returns [EObject current=null] : (this_INTERVAL_0= ruleINTERVAL | this_LSET_1= ruleLSET ) ;
    public final EObject ruleRANGE() throws RecognitionException {
        EObject current = null;

        EObject this_INTERVAL_0 = null;

        EObject this_LSET_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1216:28: ( (this_INTERVAL_0= ruleINTERVAL | this_LSET_1= ruleLSET ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1217:1: (this_INTERVAL_0= ruleINTERVAL | this_LSET_1= ruleLSET )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1217:1: (this_INTERVAL_0= ruleINTERVAL | this_LSET_1= ruleLSET )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=47 && LA16_0<=48)) ) {
                alt16=1;
            }
            else if ( (LA16_0==17) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1218:5: this_INTERVAL_0= ruleINTERVAL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRANGEAccess().getINTERVALParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTERVAL_in_ruleRANGE2690);
                    this_INTERVAL_0=ruleINTERVAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_INTERVAL_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1228:5: this_LSET_1= ruleLSET
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRANGEAccess().getLSETParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLSET_in_ruleRANGE2717);
                    this_LSET_1=ruleLSET();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LSET_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRANGE"


    // $ANTLR start "entryRuleINTERVAL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1244:1: entryRuleINTERVAL returns [EObject current=null] : iv_ruleINTERVAL= ruleINTERVAL EOF ;
    public final EObject entryRuleINTERVAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleINTERVAL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1245:2: (iv_ruleINTERVAL= ruleINTERVAL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1246:2: iv_ruleINTERVAL= ruleINTERVAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTERVALRule()); 
            }
            pushFollow(FOLLOW_ruleINTERVAL_in_entryRuleINTERVAL2752);
            iv_ruleINTERVAL=ruleINTERVAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTERVAL; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTERVAL2762); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTERVAL"


    // $ANTLR start "ruleINTERVAL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1253:1: ruleINTERVAL returns [EObject current=null] : ( ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) ) ( (lv_min_1_0= ruleLiteral ) ) otherlv_2= '..' ( (lv_max_3_0= ruleLiteral ) ) ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) ) ) ;
    public final EObject ruleINTERVAL() throws RecognitionException {
        EObject current = null;

        Token lv_lsqbr_0_1=null;
        Token lv_lsqbr_0_2=null;
        Token otherlv_2=null;
        Token lv_rsqbr_4_1=null;
        Token lv_rsqbr_4_2=null;
        EObject lv_min_1_0 = null;

        EObject lv_max_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1256:28: ( ( ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) ) ( (lv_min_1_0= ruleLiteral ) ) otherlv_2= '..' ( (lv_max_3_0= ruleLiteral ) ) ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1257:1: ( ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) ) ( (lv_min_1_0= ruleLiteral ) ) otherlv_2= '..' ( (lv_max_3_0= ruleLiteral ) ) ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1257:1: ( ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) ) ( (lv_min_1_0= ruleLiteral ) ) otherlv_2= '..' ( (lv_max_3_0= ruleLiteral ) ) ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1257:2: ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) ) ( (lv_min_1_0= ruleLiteral ) ) otherlv_2= '..' ( (lv_max_3_0= ruleLiteral ) ) ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1257:2: ( ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1258:1: ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1258:1: ( (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1259:1: (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1259:1: (lv_lsqbr_0_1= ']' | lv_lsqbr_0_2= '[' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==47) ) {
                alt17=1;
            }
            else if ( (LA17_0==48) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1260:3: lv_lsqbr_0_1= ']'
                    {
                    lv_lsqbr_0_1=(Token)match(input,47,FOLLOW_47_in_ruleINTERVAL2807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_lsqbr_0_1, grammarAccess.getINTERVALAccess().getLsqbrRightSquareBracketKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getINTERVALRule());
                      	        }
                             		setWithLastConsumed(current, "lsqbr", lv_lsqbr_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1272:8: lv_lsqbr_0_2= '['
                    {
                    lv_lsqbr_0_2=(Token)match(input,48,FOLLOW_48_in_ruleINTERVAL2836); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_lsqbr_0_2, grammarAccess.getINTERVALAccess().getLsqbrLeftSquareBracketKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getINTERVALRule());
                      	        }
                             		setWithLastConsumed(current, "lsqbr", lv_lsqbr_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1287:2: ( (lv_min_1_0= ruleLiteral ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1288:1: (lv_min_1_0= ruleLiteral )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1288:1: (lv_min_1_0= ruleLiteral )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1289:3: lv_min_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getINTERVALAccess().getMinLiteralParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleINTERVAL2873);
            lv_min_1_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getINTERVALRule());
              	        }
                     		set(
                     			current, 
                     			"min",
                      		lv_min_1_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleINTERVAL2885); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getINTERVALAccess().getFullStopFullStopKeyword_2());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1309:1: ( (lv_max_3_0= ruleLiteral ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1310:1: (lv_max_3_0= ruleLiteral )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1310:1: (lv_max_3_0= ruleLiteral )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1311:3: lv_max_3_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getINTERVALAccess().getMaxLiteralParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleINTERVAL2906);
            lv_max_3_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getINTERVALRule());
              	        }
                     		set(
                     			current, 
                     			"max",
                      		lv_max_3_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1327:2: ( ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1328:1: ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1328:1: ( (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1329:1: (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1329:1: (lv_rsqbr_4_1= ']' | lv_rsqbr_4_2= '[' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==47) ) {
                alt18=1;
            }
            else if ( (LA18_0==48) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1330:3: lv_rsqbr_4_1= ']'
                    {
                    lv_rsqbr_4_1=(Token)match(input,47,FOLLOW_47_in_ruleINTERVAL2926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_rsqbr_4_1, grammarAccess.getINTERVALAccess().getRsqbrRightSquareBracketKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getINTERVALRule());
                      	        }
                             		setWithLastConsumed(current, "rsqbr", lv_rsqbr_4_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1342:8: lv_rsqbr_4_2= '['
                    {
                    lv_rsqbr_4_2=(Token)match(input,48,FOLLOW_48_in_ruleINTERVAL2955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_rsqbr_4_2, grammarAccess.getINTERVALAccess().getRsqbrLeftSquareBracketKeyword_4_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getINTERVALRule());
                      	        }
                             		setWithLastConsumed(current, "rsqbr", lv_rsqbr_4_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTERVAL"


    // $ANTLR start "entryRuleLSET"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1365:1: entryRuleLSET returns [EObject current=null] : iv_ruleLSET= ruleLSET EOF ;
    public final EObject entryRuleLSET() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLSET = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1366:2: (iv_ruleLSET= ruleLSET EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1367:2: iv_ruleLSET= ruleLSET EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLSETRule()); 
            }
            pushFollow(FOLLOW_ruleLSET_in_entryRuleLSET3007);
            iv_ruleLSET=ruleLSET();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLSET; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLSET3017); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLSET"


    // $ANTLR start "ruleLSET"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1374:1: ruleLSET returns [EObject current=null] : (otherlv_0= '{' () ( (lv_value_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleLSET() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1377:28: ( (otherlv_0= '{' () ( (lv_value_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )* otherlv_5= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1378:1: (otherlv_0= '{' () ( (lv_value_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )* otherlv_5= '}' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1378:1: (otherlv_0= '{' () ( (lv_value_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )* otherlv_5= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1378:3: otherlv_0= '{' () ( (lv_value_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleLSET3054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLSETAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1382:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1383:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLSETAccess().getLSETAction_1(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1388:2: ( (lv_value_2_0= ruleLiteral ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1389:1: (lv_value_2_0= ruleLiteral )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1389:1: (lv_value_2_0= ruleLiteral )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1390:3: lv_value_2_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLSETAccess().getValueLiteralParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLiteral_in_ruleLSET3084);
            lv_value_2_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLSETRule());
              	        }
                     		add(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"Literal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1406:2: (otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1406:4: otherlv_3= ',' ( (lv_value_4_0= ruleLiteral ) )
            	    {
            	    otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleLSET3097); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getLSETAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1410:1: ( (lv_value_4_0= ruleLiteral ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1411:1: (lv_value_4_0= ruleLiteral )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1411:1: (lv_value_4_0= ruleLiteral )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1412:3: lv_value_4_0= ruleLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLSETAccess().getValueLiteralParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLiteral_in_ruleLSET3118);
            	    lv_value_4_0=ruleLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLSETRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"value",
            	              		lv_value_4_0, 
            	              		"Literal");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleLSET3132); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLSETAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLSET"


    // $ANTLR start "entryRuleLiteral"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1440:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1441:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1442:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3168);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3178); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1449:1: ruleLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (lv_value_15_0= '?' ) ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_0=null;
        Token lv_value_11_0=null;
        Token lv_value_13_0=null;
        Token lv_value_15_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1452:28: ( ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (lv_value_15_0= '?' ) ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (lv_value_15_0= '?' ) ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (lv_value_15_0= '?' ) ) ) )
            int alt20=8;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:2: ( () ( (lv_value_1_0= ruleINTEGER ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:2: ( () ( (lv_value_1_0= ruleINTEGER ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:3: () ( (lv_value_1_0= ruleINTEGER ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1453:3: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1454:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getIntLITERALAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1459:2: ( (lv_value_1_0= ruleINTEGER ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1460:1: (lv_value_1_0= ruleINTEGER )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1460:1: (lv_value_1_0= ruleINTEGER )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1461:3: lv_value_1_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralAccess().getValueINTEGERParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleLiteral3234);
                    lv_value_1_0=ruleINTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1478:6: ( () ( (lv_value_3_0= ruleDECIMAL ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1478:6: ( () ( (lv_value_3_0= ruleDECIMAL ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1478:7: () ( (lv_value_3_0= ruleDECIMAL ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1478:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1479:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getRealLITERALAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1484:2: ( (lv_value_3_0= ruleDECIMAL ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1485:1: (lv_value_3_0= ruleDECIMAL )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1485:1: (lv_value_3_0= ruleDECIMAL )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1486:3: lv_value_3_0= ruleDECIMAL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteralAccess().getValueDECIMALParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDECIMAL_in_ruleLiteral3272);
                    lv_value_3_0=ruleDECIMAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"DECIMAL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1503:6: ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1503:6: ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1503:7: () ( (lv_value_5_0= RULE_BOOLEAN ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1503:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1504:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getBoolLITERALAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1509:2: ( (lv_value_5_0= RULE_BOOLEAN ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1510:1: (lv_value_5_0= RULE_BOOLEAN )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1510:1: (lv_value_5_0= RULE_BOOLEAN )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1511:3: lv_value_5_0= RULE_BOOLEAN
                    {
                    lv_value_5_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleLiteral3306); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_5_0, grammarAccess.getLiteralAccess().getValueBOOLEANTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_5_0, 
                              		"BOOLEAN");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1528:6: ( () ( (lv_value_7_0= RULE_STRING ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1528:6: ( () ( (lv_value_7_0= RULE_STRING ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1528:7: () ( (lv_value_7_0= RULE_STRING ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1528:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1529:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getStrLITERALAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1534:2: ( (lv_value_7_0= RULE_STRING ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1535:1: (lv_value_7_0= RULE_STRING )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1535:1: (lv_value_7_0= RULE_STRING )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1536:3: lv_value_7_0= RULE_STRING
                    {
                    lv_value_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteral3345); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_7_0, grammarAccess.getLiteralAccess().getValueSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1553:6: ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1553:6: ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1553:7: () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1553:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1554:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getEnumLITERALAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1559:2: ( (lv_value_9_0= RULE_ENUM_ELEMENT ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1560:1: (lv_value_9_0= RULE_ENUM_ELEMENT )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1560:1: (lv_value_9_0= RULE_ENUM_ELEMENT )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1561:3: lv_value_9_0= RULE_ENUM_ELEMENT
                    {
                    lv_value_9_0=(Token)match(input,RULE_ENUM_ELEMENT,FOLLOW_RULE_ENUM_ELEMENT_in_ruleLiteral3384); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_9_0, grammarAccess.getLiteralAccess().getValueENUM_ELEMENTTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_9_0, 
                              		"ENUM_ELEMENT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1578:6: ( () ( (lv_value_11_0= RULE_BIT ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1578:6: ( () ( (lv_value_11_0= RULE_BIT ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1578:7: () ( (lv_value_11_0= RULE_BIT ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1578:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1579:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getBitLITERALAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1584:2: ( (lv_value_11_0= RULE_BIT ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1585:1: (lv_value_11_0= RULE_BIT )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1585:1: (lv_value_11_0= RULE_BIT )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1586:3: lv_value_11_0= RULE_BIT
                    {
                    lv_value_11_0=(Token)match(input,RULE_BIT,FOLLOW_RULE_BIT_in_ruleLiteral3423); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_11_0, grammarAccess.getLiteralAccess().getValueBITTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_11_0, 
                              		"BIT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1603:6: ( () ( (lv_value_13_0= RULE_HEX ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1603:6: ( () ( (lv_value_13_0= RULE_HEX ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1603:7: () ( (lv_value_13_0= RULE_HEX ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1603:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1604:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getHexLITERALAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1609:2: ( (lv_value_13_0= RULE_HEX ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1610:1: (lv_value_13_0= RULE_HEX )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1610:1: (lv_value_13_0= RULE_HEX )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1611:3: lv_value_13_0= RULE_HEX
                    {
                    lv_value_13_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleLiteral3462); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_13_0, grammarAccess.getLiteralAccess().getValueHEXTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_13_0, 
                              		"HEX");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1628:6: ( () ( (lv_value_15_0= '?' ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1628:6: ( () ( (lv_value_15_0= '?' ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1628:7: () ( (lv_value_15_0= '?' ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1628:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1629:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getUnknowLITERALAction_7_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1634:2: ( (lv_value_15_0= '?' ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1635:1: (lv_value_15_0= '?' )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1635:1: (lv_value_15_0= '?' )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1636:3: lv_value_15_0= '?'
                    {
                    lv_value_15_0=(Token)match(input,50,FOLLOW_50_in_ruleLiteral3502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_15_0, grammarAccess.getLiteralAccess().getValueQuestionMarkKeyword_7_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", lv_value_15_0, "?");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleSTATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1657:1: entryRuleSTATEMENT returns [EObject current=null] : iv_ruleSTATEMENT= ruleSTATEMENT EOF ;
    public final EObject entryRuleSTATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTATEMENT = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1658:2: (iv_ruleSTATEMENT= ruleSTATEMENT EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1659:2: iv_ruleSTATEMENT= ruleSTATEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTATEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleSTATEMENT_in_entryRuleSTATEMENT3552);
            iv_ruleSTATEMENT=ruleSTATEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTATEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTATEMENT3562); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTATEMENT"


    // $ANTLR start "ruleSTATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1666:1: ruleSTATEMENT returns [EObject current=null] : (this_AbstractVAR_DECL_0= ruleAbstractVAR_DECL | this_IF_STATEMENT_1= ruleIF_STATEMENT | this_LOOP_STATEMENT_2= ruleLOOP_STATEMENT | this_ASSIGN_STATEMENT_3= ruleASSIGN_STATEMENT | this_ERROR_STATEMENT_4= ruleERROR_STATEMENT ) ;
    public final EObject ruleSTATEMENT() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractVAR_DECL_0 = null;

        EObject this_IF_STATEMENT_1 = null;

        EObject this_LOOP_STATEMENT_2 = null;

        EObject this_ASSIGN_STATEMENT_3 = null;

        EObject this_ERROR_STATEMENT_4 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1669:28: ( (this_AbstractVAR_DECL_0= ruleAbstractVAR_DECL | this_IF_STATEMENT_1= ruleIF_STATEMENT | this_LOOP_STATEMENT_2= ruleLOOP_STATEMENT | this_ASSIGN_STATEMENT_3= ruleASSIGN_STATEMENT | this_ERROR_STATEMENT_4= ruleERROR_STATEMENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1670:1: (this_AbstractVAR_DECL_0= ruleAbstractVAR_DECL | this_IF_STATEMENT_1= ruleIF_STATEMENT | this_LOOP_STATEMENT_2= ruleLOOP_STATEMENT | this_ASSIGN_STATEMENT_3= ruleASSIGN_STATEMENT | this_ERROR_STATEMENT_4= ruleERROR_STATEMENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1670:1: (this_AbstractVAR_DECL_0= ruleAbstractVAR_DECL | this_IF_STATEMENT_1= ruleIF_STATEMENT | this_LOOP_STATEMENT_2= ruleLOOP_STATEMENT | this_ASSIGN_STATEMENT_3= ruleASSIGN_STATEMENT | this_ERROR_STATEMENT_4= ruleERROR_STATEMENT )
            int alt21=5;
            switch ( input.LA(1) ) {
            case 34:
            case 35:
            case 36:
            case 37:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt21=1;
                }
                break;
            case 51:
                {
                alt21=2;
                }
                break;
            case 55:
                {
                alt21=3;
                }
                break;
            case RULE_IDENT:
                {
                alt21=4;
                }
                break;
            case 56:
                {
                alt21=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1671:5: this_AbstractVAR_DECL_0= ruleAbstractVAR_DECL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSTATEMENTAccess().getAbstractVAR_DECLParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAbstractVAR_DECL_in_ruleSTATEMENT3609);
                    this_AbstractVAR_DECL_0=ruleAbstractVAR_DECL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AbstractVAR_DECL_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1681:5: this_IF_STATEMENT_1= ruleIF_STATEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSTATEMENTAccess().getIF_STATEMENTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIF_STATEMENT_in_ruleSTATEMENT3636);
                    this_IF_STATEMENT_1=ruleIF_STATEMENT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IF_STATEMENT_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1691:5: this_LOOP_STATEMENT_2= ruleLOOP_STATEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSTATEMENTAccess().getLOOP_STATEMENTParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLOOP_STATEMENT_in_ruleSTATEMENT3663);
                    this_LOOP_STATEMENT_2=ruleLOOP_STATEMENT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LOOP_STATEMENT_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1701:5: this_ASSIGN_STATEMENT_3= ruleASSIGN_STATEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSTATEMENTAccess().getASSIGN_STATEMENTParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASSIGN_STATEMENT_in_ruleSTATEMENT3690);
                    this_ASSIGN_STATEMENT_3=ruleASSIGN_STATEMENT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASSIGN_STATEMENT_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1711:5: this_ERROR_STATEMENT_4= ruleERROR_STATEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSTATEMENTAccess().getERROR_STATEMENTParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleERROR_STATEMENT_in_ruleSTATEMENT3717);
                    this_ERROR_STATEMENT_4=ruleERROR_STATEMENT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ERROR_STATEMENT_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTATEMENT"


    // $ANTLR start "entryRuleIF_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1727:1: entryRuleIF_STATEMENT returns [EObject current=null] : iv_ruleIF_STATEMENT= ruleIF_STATEMENT EOF ;
    public final EObject entryRuleIF_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIF_STATEMENT = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1728:2: (iv_ruleIF_STATEMENT= ruleIF_STATEMENT EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1729:2: iv_ruleIF_STATEMENT= ruleIF_STATEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIF_STATEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleIF_STATEMENT_in_entryRuleIF_STATEMENT3752);
            iv_ruleIF_STATEMENT=ruleIF_STATEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIF_STATEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIF_STATEMENT3762); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIF_STATEMENT"


    // $ANTLR start "ruleIF_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1736:1: ruleIF_STATEMENT returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_ifCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_ifst_5_0= ruleSTATEMENT ) )* otherlv_6= '}' ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' ) ) ;
    public final EObject ruleIF_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ifCond_2_0 = null;

        EObject lv_ifst_5_0 = null;

        EObject lv_elst_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1739:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_ifCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_ifst_5_0= ruleSTATEMENT ) )* otherlv_6= '}' ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1740:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_ifCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_ifst_5_0= ruleSTATEMENT ) )* otherlv_6= '}' ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1740:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_ifCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_ifst_5_0= ruleSTATEMENT ) )* otherlv_6= '}' ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1740:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_ifCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_ifst_5_0= ruleSTATEMENT ) )* otherlv_6= '}' ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleIF_STATEMENT3799); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIF_STATEMENTAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleIF_STATEMENT3811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIF_STATEMENTAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1748:1: ( (lv_ifCond_2_0= ruleEXPRESSION ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1749:1: (lv_ifCond_2_0= ruleEXPRESSION )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1749:1: (lv_ifCond_2_0= ruleEXPRESSION )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1750:3: lv_ifCond_2_0= ruleEXPRESSION
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIF_STATEMENTAccess().getIfCondEXPRESSIONParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEXPRESSION_in_ruleIF_STATEMENT3832);
            lv_ifCond_2_0=ruleEXPRESSION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIF_STATEMENTRule());
              	        }
                     		set(
                     			current, 
                     			"ifCond",
                      		lv_ifCond_2_0, 
                      		"EXPRESSION");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleIF_STATEMENT3844); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIF_STATEMENTAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleIF_STATEMENT3856); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIF_STATEMENTAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1774:1: ( (lv_ifst_5_0= ruleSTATEMENT ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_IDENT||(LA22_0>=34 && LA22_0<=37)||(LA22_0>=40 && LA22_0<=46)||LA22_0==51||(LA22_0>=55 && LA22_0<=56)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1775:1: (lv_ifst_5_0= ruleSTATEMENT )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1775:1: (lv_ifst_5_0= ruleSTATEMENT )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1776:3: lv_ifst_5_0= ruleSTATEMENT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIF_STATEMENTAccess().getIfstSTATEMENTParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSTATEMENT_in_ruleIF_STATEMENT3877);
            	    lv_ifst_5_0=ruleSTATEMENT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIF_STATEMENTRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ifst",
            	              		lv_ifst_5_0, 
            	              		"STATEMENT");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleIF_STATEMENT3890); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIF_STATEMENTAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1796:1: ( ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1796:2: ( ( 'else' )=>otherlv_7= 'else' ) otherlv_8= '{' ( (lv_elst_9_0= ruleSTATEMENT ) )* otherlv_10= '}'
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1796:2: ( ( 'else' )=>otherlv_7= 'else' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1796:3: ( 'else' )=>otherlv_7= 'else'
            {
            otherlv_7=(Token)match(input,54,FOLLOW_54_in_ruleIF_STATEMENT3911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIF_STATEMENTAccess().getElseKeyword_7_0());
                  
            }

            }

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleIF_STATEMENT3924); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getIF_STATEMENTAccess().getLeftCurlyBracketKeyword_7_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1805:1: ( (lv_elst_9_0= ruleSTATEMENT ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_IDENT||(LA23_0>=34 && LA23_0<=37)||(LA23_0>=40 && LA23_0<=46)||LA23_0==51||(LA23_0>=55 && LA23_0<=56)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1806:1: (lv_elst_9_0= ruleSTATEMENT )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1806:1: (lv_elst_9_0= ruleSTATEMENT )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1807:3: lv_elst_9_0= ruleSTATEMENT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIF_STATEMENTAccess().getElstSTATEMENTParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSTATEMENT_in_ruleIF_STATEMENT3945);
            	    lv_elst_9_0=ruleSTATEMENT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIF_STATEMENTRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elst",
            	              		lv_elst_9_0, 
            	              		"STATEMENT");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleIF_STATEMENT3958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getIF_STATEMENTAccess().getRightCurlyBracketKeyword_7_3());
                  
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIF_STATEMENT"


    // $ANTLR start "entryRuleLOOP_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1835:1: entryRuleLOOP_STATEMENT returns [EObject current=null] : iv_ruleLOOP_STATEMENT= ruleLOOP_STATEMENT EOF ;
    public final EObject entryRuleLOOP_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLOOP_STATEMENT = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1836:2: (iv_ruleLOOP_STATEMENT= ruleLOOP_STATEMENT EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1837:2: iv_ruleLOOP_STATEMENT= ruleLOOP_STATEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOOP_STATEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleLOOP_STATEMENT_in_entryRuleLOOP_STATEMENT3995);
            iv_ruleLOOP_STATEMENT=ruleLOOP_STATEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOOP_STATEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLOOP_STATEMENT4005); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLOOP_STATEMENT"


    // $ANTLR start "ruleLOOP_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1844:1: ruleLOOP_STATEMENT returns [EObject current=null] : (otherlv_0= 'loop' otherlv_1= '(' ( (lv_loopCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' ) ;
    public final EObject ruleLOOP_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_loopCond_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1847:28: ( (otherlv_0= 'loop' otherlv_1= '(' ( (lv_loopCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1848:1: (otherlv_0= 'loop' otherlv_1= '(' ( (lv_loopCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1848:1: (otherlv_0= 'loop' otherlv_1= '(' ( (lv_loopCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1848:3: otherlv_0= 'loop' otherlv_1= '(' ( (lv_loopCond_2_0= ruleEXPRESSION ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleLOOP_STATEMENT4042); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLOOP_STATEMENTAccess().getLoopKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleLOOP_STATEMENT4054); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLOOP_STATEMENTAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1856:1: ( (lv_loopCond_2_0= ruleEXPRESSION ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1857:1: (lv_loopCond_2_0= ruleEXPRESSION )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1857:1: (lv_loopCond_2_0= ruleEXPRESSION )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1858:3: lv_loopCond_2_0= ruleEXPRESSION
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLOOP_STATEMENTAccess().getLoopCondEXPRESSIONParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEXPRESSION_in_ruleLOOP_STATEMENT4075);
            lv_loopCond_2_0=ruleEXPRESSION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLOOP_STATEMENTRule());
              	        }
                     		set(
                     			current, 
                     			"loopCond",
                      		lv_loopCond_2_0, 
                      		"EXPRESSION");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleLOOP_STATEMENT4087); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLOOP_STATEMENTAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLOOP_STATEMENT"


    // $ANTLR start "entryRuleERROR_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1886:1: entryRuleERROR_STATEMENT returns [EObject current=null] : iv_ruleERROR_STATEMENT= ruleERROR_STATEMENT EOF ;
    public final EObject entryRuleERROR_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleERROR_STATEMENT = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1887:2: (iv_ruleERROR_STATEMENT= ruleERROR_STATEMENT EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1888:2: iv_ruleERROR_STATEMENT= ruleERROR_STATEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getERROR_STATEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleERROR_STATEMENT_in_entryRuleERROR_STATEMENT4123);
            iv_ruleERROR_STATEMENT=ruleERROR_STATEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleERROR_STATEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleERROR_STATEMENT4133); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleERROR_STATEMENT"


    // $ANTLR start "ruleERROR_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1895:1: ruleERROR_STATEMENT returns [EObject current=null] : (otherlv_0= 'error' () (otherlv_2= ';' )? ) ;
    public final EObject ruleERROR_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1898:28: ( (otherlv_0= 'error' () (otherlv_2= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1899:1: (otherlv_0= 'error' () (otherlv_2= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1899:1: (otherlv_0= 'error' () (otherlv_2= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1899:3: otherlv_0= 'error' () (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleERROR_STATEMENT4170); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getERROR_STATEMENTAccess().getErrorKeyword_0());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1903:1: ()
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1904:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getERROR_STATEMENTAccess().getERROR_STATEMENTAction_1(),
                          current);
                  
            }

            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1909:2: (otherlv_2= ';' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==25) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1909:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleERROR_STATEMENT4192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getERROR_STATEMENTAccess().getSemicolonKeyword_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleERROR_STATEMENT"


    // $ANTLR start "entryRuleASSIGN_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1921:1: entryRuleASSIGN_STATEMENT returns [EObject current=null] : iv_ruleASSIGN_STATEMENT= ruleASSIGN_STATEMENT EOF ;
    public final EObject entryRuleASSIGN_STATEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASSIGN_STATEMENT = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1922:2: (iv_ruleASSIGN_STATEMENT= ruleASSIGN_STATEMENT EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1923:2: iv_ruleASSIGN_STATEMENT= ruleASSIGN_STATEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASSIGN_STATEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleASSIGN_STATEMENT_in_entryRuleASSIGN_STATEMENT4230);
            iv_ruleASSIGN_STATEMENT=ruleASSIGN_STATEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASSIGN_STATEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASSIGN_STATEMENT4240); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASSIGN_STATEMENT"


    // $ANTLR start "ruleASSIGN_STATEMENT"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1930:1: ruleASSIGN_STATEMENT returns [EObject current=null] : ( ( (lv_left_0_0= ruleVAR_REF ) ) otherlv_1= '=' ( (lv_right_2_0= ruleEXPRESSION ) ) (otherlv_3= ';' )? ) ;
    public final EObject ruleASSIGN_STATEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1933:28: ( ( ( (lv_left_0_0= ruleVAR_REF ) ) otherlv_1= '=' ( (lv_right_2_0= ruleEXPRESSION ) ) (otherlv_3= ';' )? ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1934:1: ( ( (lv_left_0_0= ruleVAR_REF ) ) otherlv_1= '=' ( (lv_right_2_0= ruleEXPRESSION ) ) (otherlv_3= ';' )? )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1934:1: ( ( (lv_left_0_0= ruleVAR_REF ) ) otherlv_1= '=' ( (lv_right_2_0= ruleEXPRESSION ) ) (otherlv_3= ';' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1934:2: ( (lv_left_0_0= ruleVAR_REF ) ) otherlv_1= '=' ( (lv_right_2_0= ruleEXPRESSION ) ) (otherlv_3= ';' )?
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1934:2: ( (lv_left_0_0= ruleVAR_REF ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1935:1: (lv_left_0_0= ruleVAR_REF )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1935:1: (lv_left_0_0= ruleVAR_REF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1936:3: lv_left_0_0= ruleVAR_REF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASSIGN_STATEMENTAccess().getLeftVAR_REFParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVAR_REF_in_ruleASSIGN_STATEMENT4286);
            lv_left_0_0=ruleVAR_REF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASSIGN_STATEMENTRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"VAR_REF");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleASSIGN_STATEMENT4298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASSIGN_STATEMENTAccess().getEqualsSignKeyword_1());
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1956:1: ( (lv_right_2_0= ruleEXPRESSION ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1957:1: (lv_right_2_0= ruleEXPRESSION )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1957:1: (lv_right_2_0= ruleEXPRESSION )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1958:3: lv_right_2_0= ruleEXPRESSION
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASSIGN_STATEMENTAccess().getRightEXPRESSIONParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEXPRESSION_in_ruleASSIGN_STATEMENT4319);
            lv_right_2_0=ruleEXPRESSION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASSIGN_STATEMENTRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
                      		"EXPRESSION");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1974:2: (otherlv_3= ';' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==25) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1974:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleASSIGN_STATEMENT4332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASSIGN_STATEMENTAccess().getSemicolonKeyword_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASSIGN_STATEMENT"


    // $ANTLR start "entryRuleVAR_REF"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1986:1: entryRuleVAR_REF returns [EObject current=null] : iv_ruleVAR_REF= ruleVAR_REF EOF ;
    public final EObject entryRuleVAR_REF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVAR_REF = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1987:2: (iv_ruleVAR_REF= ruleVAR_REF EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1988:2: iv_ruleVAR_REF= ruleVAR_REF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVAR_REFRule()); 
            }
            pushFollow(FOLLOW_ruleVAR_REF_in_entryRuleVAR_REF4370);
            iv_ruleVAR_REF=ruleVAR_REF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVAR_REF; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVAR_REF4380); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVAR_REF"


    // $ANTLR start "ruleVAR_REF"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1995:1: ruleVAR_REF returns [EObject current=null] : ( (otherlv_0= RULE_IDENT ) ) ;
    public final EObject ruleVAR_REF() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1998:28: ( ( (otherlv_0= RULE_IDENT ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1999:1: ( (otherlv_0= RULE_IDENT ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1999:1: ( (otherlv_0= RULE_IDENT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2000:1: (otherlv_0= RULE_IDENT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2000:1: (otherlv_0= RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2001:3: otherlv_0= RULE_IDENT
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVAR_REFRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleVAR_REF4424); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getVAR_REFAccess().getVariableAbstractVAR_DECLCrossReference_0()); 
              	
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVAR_REF"


    // $ANTLR start "entryRuleEXPRESSION"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2020:1: entryRuleEXPRESSION returns [EObject current=null] : iv_ruleEXPRESSION= ruleEXPRESSION EOF ;
    public final EObject entryRuleEXPRESSION() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEXPRESSION = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2021:2: (iv_ruleEXPRESSION= ruleEXPRESSION EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2022:2: iv_ruleEXPRESSION= ruleEXPRESSION EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEXPRESSIONRule()); 
            }
            pushFollow(FOLLOW_ruleEXPRESSION_in_entryRuleEXPRESSION4459);
            iv_ruleEXPRESSION=ruleEXPRESSION();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEXPRESSION; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEXPRESSION4469); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEXPRESSION"


    // $ANTLR start "ruleEXPRESSION"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2029:1: ruleEXPRESSION returns [EObject current=null] : this_OR_0= ruleOR ;
    public final EObject ruleEXPRESSION() throws RecognitionException {
        EObject current = null;

        EObject this_OR_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2032:28: (this_OR_0= ruleOR )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2034:5: this_OR_0= ruleOR
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEXPRESSIONAccess().getORParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleOR_in_ruleEXPRESSION4515);
            this_OR_0=ruleOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OR_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEXPRESSION"


    // $ANTLR start "entryRuleOR"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2050:1: entryRuleOR returns [EObject current=null] : iv_ruleOR= ruleOR EOF ;
    public final EObject entryRuleOR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOR = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2051:2: (iv_ruleOR= ruleOR EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2052:2: iv_ruleOR= ruleOR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getORRule()); 
            }
            pushFollow(FOLLOW_ruleOR_in_entryRuleOR4549);
            iv_ruleOR=ruleOR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOR; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOR4559); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOR"


    // $ANTLR start "ruleOR"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2059:1: ruleOR returns [EObject current=null] : (this_AND_0= ruleAND ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )* ) ;
    public final EObject ruleOR() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AND_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2062:28: ( (this_AND_0= ruleAND ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2063:1: (this_AND_0= ruleAND ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2063:1: (this_AND_0= ruleAND ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2064:5: this_AND_0= ruleAND ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getORAccess().getANDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAND_in_ruleOR4606);
            this_AND_0=ruleAND();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AND_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2072:1: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==58) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2072:2: () otherlv_2= 'or' ( (lv_right_3_0= ruleAND ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2072:2: ()
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2073:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getORAccess().getORLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,58,FOLLOW_58_in_ruleOR4627); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getORAccess().getOrKeyword_1_1());
            	          
            	    }
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2082:1: ( (lv_right_3_0= ruleAND ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2083:1: (lv_right_3_0= ruleAND )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2083:1: (lv_right_3_0= ruleAND )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2084:3: lv_right_3_0= ruleAND
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getORAccess().getRightANDParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAND_in_ruleOR4648);
            	    lv_right_3_0=ruleAND();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getORRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AND");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOR"


    // $ANTLR start "entryRuleAND"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2108:1: entryRuleAND returns [EObject current=null] : iv_ruleAND= ruleAND EOF ;
    public final EObject entryRuleAND() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAND = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2109:2: (iv_ruleAND= ruleAND EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2110:2: iv_ruleAND= ruleAND EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANDRule()); 
            }
            pushFollow(FOLLOW_ruleAND_in_entryRuleAND4686);
            iv_ruleAND=ruleAND();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAND; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAND4696); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAND"


    // $ANTLR start "ruleAND"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2117:1: ruleAND returns [EObject current=null] : (this_EQUAL_DIFF_0= ruleEQUAL_DIFF ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )* ) ;
    public final EObject ruleAND() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EQUAL_DIFF_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2120:28: ( (this_EQUAL_DIFF_0= ruleEQUAL_DIFF ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2121:1: (this_EQUAL_DIFF_0= ruleEQUAL_DIFF ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2121:1: (this_EQUAL_DIFF_0= ruleEQUAL_DIFF ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2122:5: this_EQUAL_DIFF_0= ruleEQUAL_DIFF ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANDAccess().getEQUAL_DIFFParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleEQUAL_DIFF_in_ruleAND4743);
            this_EQUAL_DIFF_0=ruleEQUAL_DIFF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EQUAL_DIFF_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2130:1: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==59) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2130:2: () otherlv_2= 'and' ( (lv_right_3_0= ruleEQUAL_DIFF ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2130:2: ()
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2131:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getANDAccess().getANDLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleAND4764); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getANDAccess().getAndKeyword_1_1());
            	          
            	    }
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2140:1: ( (lv_right_3_0= ruleEQUAL_DIFF ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2141:1: (lv_right_3_0= ruleEQUAL_DIFF )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2141:1: (lv_right_3_0= ruleEQUAL_DIFF )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2142:3: lv_right_3_0= ruleEQUAL_DIFF
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getANDAccess().getRightEQUAL_DIFFParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEQUAL_DIFF_in_ruleAND4785);
            	    lv_right_3_0=ruleEQUAL_DIFF();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getANDRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"EQUAL_DIFF");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAND"


    // $ANTLR start "entryRuleEQUAL_DIFF"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2166:1: entryRuleEQUAL_DIFF returns [EObject current=null] : iv_ruleEQUAL_DIFF= ruleEQUAL_DIFF EOF ;
    public final EObject entryRuleEQUAL_DIFF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEQUAL_DIFF = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2167:2: (iv_ruleEQUAL_DIFF= ruleEQUAL_DIFF EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2168:2: iv_ruleEQUAL_DIFF= ruleEQUAL_DIFF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEQUAL_DIFFRule()); 
            }
            pushFollow(FOLLOW_ruleEQUAL_DIFF_in_entryRuleEQUAL_DIFF4823);
            iv_ruleEQUAL_DIFF=ruleEQUAL_DIFF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEQUAL_DIFF; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEQUAL_DIFF4833); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEQUAL_DIFF"


    // $ANTLR start "ruleEQUAL_DIFF"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2175:1: ruleEQUAL_DIFF returns [EObject current=null] : (this_COMPARISON_0= ruleCOMPARISON ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )* ) ;
    public final EObject ruleEQUAL_DIFF() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_COMPARISON_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2178:28: ( (this_COMPARISON_0= ruleCOMPARISON ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2179:1: (this_COMPARISON_0= ruleCOMPARISON ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2179:1: (this_COMPARISON_0= ruleCOMPARISON ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2180:5: this_COMPARISON_0= ruleCOMPARISON ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEQUAL_DIFFAccess().getCOMPARISONParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleCOMPARISON_in_ruleEQUAL_DIFF4880);
            this_COMPARISON_0=ruleCOMPARISON();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_COMPARISON_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2188:1: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==38||LA29_0==60) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2188:2: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleCOMPARISON ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2188:2: ()
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2189:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEQUAL_DIFFAccess().getEQUAL_DIFFLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2194:2: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2195:1: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2195:1: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2196:1: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2196:1: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==38) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==60) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2197:3: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,38,FOLLOW_38_in_ruleEQUAL_DIFF4909); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getEQUAL_DIFFAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEQUAL_DIFFRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2209:8: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,60,FOLLOW_60_in_ruleEQUAL_DIFF4938); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getEQUAL_DIFFAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getEQUAL_DIFFRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2224:2: ( (lv_right_3_0= ruleCOMPARISON ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2225:1: (lv_right_3_0= ruleCOMPARISON )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2225:1: (lv_right_3_0= ruleCOMPARISON )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2226:3: lv_right_3_0= ruleCOMPARISON
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEQUAL_DIFFAccess().getRightCOMPARISONParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCOMPARISON_in_ruleEQUAL_DIFF4975);
            	    lv_right_3_0=ruleCOMPARISON();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEQUAL_DIFFRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"COMPARISON");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEQUAL_DIFF"


    // $ANTLR start "entryRuleCOMPARISON"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2250:1: entryRuleCOMPARISON returns [EObject current=null] : iv_ruleCOMPARISON= ruleCOMPARISON EOF ;
    public final EObject entryRuleCOMPARISON() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCOMPARISON = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2251:2: (iv_ruleCOMPARISON= ruleCOMPARISON EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2252:2: iv_ruleCOMPARISON= ruleCOMPARISON EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCOMPARISONRule()); 
            }
            pushFollow(FOLLOW_ruleCOMPARISON_in_entryRuleCOMPARISON5013);
            iv_ruleCOMPARISON=ruleCOMPARISON();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCOMPARISON; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCOMPARISON5023); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCOMPARISON"


    // $ANTLR start "ruleCOMPARISON"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2259:1: ruleCOMPARISON returns [EObject current=null] : (this_ADD_SUB_0= ruleADD_SUB ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )* ) ;
    public final EObject ruleCOMPARISON() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_ADD_SUB_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2262:28: ( (this_ADD_SUB_0= ruleADD_SUB ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2263:1: (this_ADD_SUB_0= ruleADD_SUB ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2263:1: (this_ADD_SUB_0= ruleADD_SUB ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2264:5: this_ADD_SUB_0= ruleADD_SUB ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCOMPARISONAccess().getADD_SUBParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleADD_SUB_in_ruleCOMPARISON5070);
            this_ADD_SUB_0=ruleADD_SUB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ADD_SUB_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2272:1: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=61 && LA31_0<=64)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2272:2: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleADD_SUB ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2272:2: ()
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2273:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getCOMPARISONAccess().getCOMPARISONLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2278:2: ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2279:1: ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2279:1: ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2280:1: (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2280:1: (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case 61:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 64:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2281:3: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,61,FOLLOW_61_in_ruleCOMPARISON5099); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getCOMPARISONAccess().getOpLessThanSignKeyword_1_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getCOMPARISONRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2293:8: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,62,FOLLOW_62_in_ruleCOMPARISON5128); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getCOMPARISONAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getCOMPARISONRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2305:8: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,63,FOLLOW_63_in_ruleCOMPARISON5157); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_3, grammarAccess.getCOMPARISONAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getCOMPARISONRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2317:8: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,64,FOLLOW_64_in_ruleCOMPARISON5186); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_4, grammarAccess.getCOMPARISONAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getCOMPARISONRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2332:2: ( (lv_right_3_0= ruleADD_SUB ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2333:1: (lv_right_3_0= ruleADD_SUB )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2333:1: (lv_right_3_0= ruleADD_SUB )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2334:3: lv_right_3_0= ruleADD_SUB
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCOMPARISONAccess().getRightADD_SUBParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleADD_SUB_in_ruleCOMPARISON5223);
            	    lv_right_3_0=ruleADD_SUB();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCOMPARISONRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"ADD_SUB");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOMPARISON"


    // $ANTLR start "entryRuleADD_SUB"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2358:1: entryRuleADD_SUB returns [EObject current=null] : iv_ruleADD_SUB= ruleADD_SUB EOF ;
    public final EObject entryRuleADD_SUB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADD_SUB = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2359:2: (iv_ruleADD_SUB= ruleADD_SUB EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2360:2: iv_ruleADD_SUB= ruleADD_SUB EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getADD_SUBRule()); 
            }
            pushFollow(FOLLOW_ruleADD_SUB_in_entryRuleADD_SUB5261);
            iv_ruleADD_SUB=ruleADD_SUB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleADD_SUB; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleADD_SUB5271); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleADD_SUB"


    // $ANTLR start "ruleADD_SUB"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2367:1: ruleADD_SUB returns [EObject current=null] : (this_MULT_DIV_0= ruleMULT_DIV ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )* ) ;
    public final EObject ruleADD_SUB() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MULT_DIV_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2370:28: ( (this_MULT_DIV_0= ruleMULT_DIV ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2371:1: (this_MULT_DIV_0= ruleMULT_DIV ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2371:1: (this_MULT_DIV_0= ruleMULT_DIV ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2372:5: this_MULT_DIV_0= ruleMULT_DIV ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getADD_SUBAccess().getMULT_DIVParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMULT_DIV_in_ruleADD_SUB5318);
            this_MULT_DIV_0=ruleMULT_DIV();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MULT_DIV_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=65 && LA33_0<=66)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMULT_DIV ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==65) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==66) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:3: ( () otherlv_2= '+' )
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:3: ( () otherlv_2= '+' )
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:4: () otherlv_2= '+'
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2380:4: ()
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2381:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getADD_SUBAccess().getADDLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,65,FOLLOW_65_in_ruleADD_SUB5341); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getADD_SUBAccess().getPlusSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2391:6: ( () otherlv_4= '-' )
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2391:6: ( () otherlv_4= '-' )
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2391:7: () otherlv_4= '-'
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2391:7: ()
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2392:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getADD_SUBAccess().getSUBLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,66,FOLLOW_66_in_ruleADD_SUB5370); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getADD_SUBAccess().getHyphenMinusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2401:3: ( (lv_right_5_0= ruleMULT_DIV ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2402:1: (lv_right_5_0= ruleMULT_DIV )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2402:1: (lv_right_5_0= ruleMULT_DIV )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2403:3: lv_right_5_0= ruleMULT_DIV
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getADD_SUBAccess().getRightMULT_DIVParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMULT_DIV_in_ruleADD_SUB5393);
            	    lv_right_5_0=ruleMULT_DIV();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getADD_SUBRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"MULT_DIV");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleADD_SUB"


    // $ANTLR start "entryRuleMULT_DIV"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2427:1: entryRuleMULT_DIV returns [EObject current=null] : iv_ruleMULT_DIV= ruleMULT_DIV EOF ;
    public final EObject entryRuleMULT_DIV() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMULT_DIV = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2428:2: (iv_ruleMULT_DIV= ruleMULT_DIV EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2429:2: iv_ruleMULT_DIV= ruleMULT_DIV EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMULT_DIVRule()); 
            }
            pushFollow(FOLLOW_ruleMULT_DIV_in_entryRuleMULT_DIV5431);
            iv_ruleMULT_DIV=ruleMULT_DIV();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMULT_DIV; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMULT_DIV5441); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMULT_DIV"


    // $ANTLR start "ruleMULT_DIV"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2436:1: ruleMULT_DIV returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMULT_DIV() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2439:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2440:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2440:1: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2441:5: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMULT_DIVAccess().getPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleMULT_DIV5488);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_PrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=67 && LA35_0<=68)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==67) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==68) ) {
            	        alt34=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:3: ( () otherlv_2= '*' )
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:3: ( () otherlv_2= '*' )
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:4: () otherlv_2= '*'
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2449:4: ()
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2450:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getMULT_DIVAccess().getMULTLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,67,FOLLOW_67_in_ruleMULT_DIV5511); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getMULT_DIVAccess().getAsteriskKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2460:6: ( () otherlv_4= '/' )
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2460:6: ( () otherlv_4= '/' )
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2460:7: () otherlv_4= '/'
            	            {
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2460:7: ()
            	            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2461:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getMULT_DIVAccess().getDIVLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,68,FOLLOW_68_in_ruleMULT_DIV5540); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getMULT_DIVAccess().getSolidusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2470:3: ( (lv_right_5_0= rulePrimaryExpression ) )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2471:1: (lv_right_5_0= rulePrimaryExpression )
            	    {
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2471:1: (lv_right_5_0= rulePrimaryExpression )
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2472:3: lv_right_5_0= rulePrimaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMULT_DIVAccess().getRightPrimaryExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleMULT_DIV5563);
            	    lv_right_5_0=rulePrimaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMULT_DIVRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"PrimaryExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMULT_DIV"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2496:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2497:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2498:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5601);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression5611); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2505:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' ) | ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_EXPRESSION_1 = null;

        EObject lv_exp_5_0 = null;

        EObject this_Atomic_6 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2508:28: ( ( (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' ) | ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) ) | this_Atomic_6= ruleAtomic ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2509:1: ( (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' ) | ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2509:1: ( (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' ) | ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) ) | this_Atomic_6= ruleAtomic )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt36=1;
                }
                break;
            case 69:
                {
                alt36=2;
                }
                break;
            case RULE_IDENT:
            case RULE_BOOLEAN:
            case RULE_STRING:
            case RULE_ENUM_ELEMENT:
            case RULE_BIT:
            case RULE_HEX:
            case RULE_INT:
            case 66:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2509:2: (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2509:2: (otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')' )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2509:4: otherlv_0= '(' this_EXPRESSION_1= ruleEXPRESSION otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,52,FOLLOW_52_in_rulePrimaryExpression5649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEXPRESSIONParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEXPRESSION_in_rulePrimaryExpression5671);
                    this_EXPRESSION_1=ruleEXPRESSION();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EXPRESSION_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,53,FOLLOW_53_in_rulePrimaryExpression5682); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2527:6: ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2527:6: ( () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2527:7: () otherlv_4= 'not' ( (lv_exp_5_0= rulePrimaryExpression ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2527:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2528:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrimaryExpressionAccess().getNOTAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,69,FOLLOW_69_in_rulePrimaryExpression5711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getNotKeyword_1_1());
                          
                    }
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2537:1: ( (lv_exp_5_0= rulePrimaryExpression ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2538:1: (lv_exp_5_0= rulePrimaryExpression )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2538:1: (lv_exp_5_0= rulePrimaryExpression )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2539:3: lv_exp_5_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rulePrimaryExpression5732);
                    lv_exp_5_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_5_0, 
                              		"PrimaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2557:5: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAtomicParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rulePrimaryExpression5761);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Atomic_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleAtomic"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2573:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2574:2: (iv_ruleAtomic= ruleAtomic EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2575:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic5796);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic5806); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2582:1: ruleAtomic returns [EObject current=null] : ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (otherlv_15= RULE_IDENT ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_0=null;
        Token lv_value_11_0=null;
        Token lv_value_13_0=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2585:28: ( ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (otherlv_15= RULE_IDENT ) ) ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (otherlv_15= RULE_IDENT ) ) ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (otherlv_15= RULE_IDENT ) ) ) )
            int alt37=8;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:2: ( () ( (lv_value_1_0= ruleINTEGER ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:2: ( () ( (lv_value_1_0= ruleINTEGER ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:3: () ( (lv_value_1_0= ruleINTEGER ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2586:3: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2587:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getIntConstantAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2592:2: ( (lv_value_1_0= ruleINTEGER ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2593:1: (lv_value_1_0= ruleINTEGER )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2593:1: (lv_value_1_0= ruleINTEGER )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2594:3: lv_value_1_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicAccess().getValueINTEGERParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleAtomic5862);
                    lv_value_1_0=ruleINTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2611:6: ( () ( (lv_value_3_0= ruleDECIMAL ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2611:6: ( () ( (lv_value_3_0= ruleDECIMAL ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2611:7: () ( (lv_value_3_0= ruleDECIMAL ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2611:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2612:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getRealConstantAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2617:2: ( (lv_value_3_0= ruleDECIMAL ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2618:1: (lv_value_3_0= ruleDECIMAL )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2618:1: (lv_value_3_0= ruleDECIMAL )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2619:3: lv_value_3_0= ruleDECIMAL
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicAccess().getValueDECIMALParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDECIMAL_in_ruleAtomic5900);
                    lv_value_3_0=ruleDECIMAL();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_3_0, 
                              		"DECIMAL");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2636:6: ( () ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2636:6: ( () ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2636:7: () ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2636:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2637:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getStrConstantAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2642:2: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2643:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2643:1: (lv_value_5_0= RULE_STRING )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2644:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomic5934); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_5_0, grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2661:6: ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2661:6: ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2661:7: () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2661:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2662:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getEnumConstantAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2667:2: ( (lv_value_7_0= RULE_ENUM_ELEMENT ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2668:1: (lv_value_7_0= RULE_ENUM_ELEMENT )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2668:1: (lv_value_7_0= RULE_ENUM_ELEMENT )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2669:3: lv_value_7_0= RULE_ENUM_ELEMENT
                    {
                    lv_value_7_0=(Token)match(input,RULE_ENUM_ELEMENT,FOLLOW_RULE_ENUM_ELEMENT_in_ruleAtomic5973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_7_0, grammarAccess.getAtomicAccess().getValueENUM_ELEMENTTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_7_0, 
                              		"ENUM_ELEMENT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2686:6: ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2686:6: ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2686:7: () ( (lv_value_9_0= RULE_BOOLEAN ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2686:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2687:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getBoolConstantAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2692:2: ( (lv_value_9_0= RULE_BOOLEAN ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2693:1: (lv_value_9_0= RULE_BOOLEAN )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2693:1: (lv_value_9_0= RULE_BOOLEAN )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2694:3: lv_value_9_0= RULE_BOOLEAN
                    {
                    lv_value_9_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleAtomic6012); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_9_0, grammarAccess.getAtomicAccess().getValueBOOLEANTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_9_0, 
                              		"BOOLEAN");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2711:6: ( () ( (lv_value_11_0= RULE_BIT ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2711:6: ( () ( (lv_value_11_0= RULE_BIT ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2711:7: () ( (lv_value_11_0= RULE_BIT ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2711:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2712:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getBitConstantAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2717:2: ( (lv_value_11_0= RULE_BIT ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2718:1: (lv_value_11_0= RULE_BIT )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2718:1: (lv_value_11_0= RULE_BIT )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2719:3: lv_value_11_0= RULE_BIT
                    {
                    lv_value_11_0=(Token)match(input,RULE_BIT,FOLLOW_RULE_BIT_in_ruleAtomic6051); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_11_0, grammarAccess.getAtomicAccess().getValueBITTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_11_0, 
                              		"BIT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2736:6: ( () ( (lv_value_13_0= RULE_HEX ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2736:6: ( () ( (lv_value_13_0= RULE_HEX ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2736:7: () ( (lv_value_13_0= RULE_HEX ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2736:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2737:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getHexConstantAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2742:2: ( (lv_value_13_0= RULE_HEX ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2743:1: (lv_value_13_0= RULE_HEX )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2743:1: (lv_value_13_0= RULE_HEX )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2744:3: lv_value_13_0= RULE_HEX
                    {
                    lv_value_13_0=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleAtomic6090); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_13_0, grammarAccess.getAtomicAccess().getValueHEXTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_13_0, 
                              		"HEX");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2761:6: ( () ( (otherlv_15= RULE_IDENT ) ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2761:6: ( () ( (otherlv_15= RULE_IDENT ) ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2761:7: () ( (otherlv_15= RULE_IDENT ) )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2761:7: ()
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2762:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getVarExpRefAction_7_0(),
                                  current);
                          
                    }

                    }

                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2767:2: ( (otherlv_15= RULE_IDENT ) )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2768:1: (otherlv_15= RULE_IDENT )
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2768:1: (otherlv_15= RULE_IDENT )
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2769:3: otherlv_15= RULE_IDENT
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                              
                    }
                    otherlv_15=(Token)match(input,RULE_IDENT,FOLLOW_RULE_IDENT_in_ruleAtomic6132); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_15, grammarAccess.getAtomicAccess().getVrefAbstractVAR_DECLCrossReference_7_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleDECIMAL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2788:1: entryRuleDECIMAL returns [String current=null] : iv_ruleDECIMAL= ruleDECIMAL EOF ;
    public final String entryRuleDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECIMAL = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2789:2: (iv_ruleDECIMAL= ruleDECIMAL EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2790:2: iv_ruleDECIMAL= ruleDECIMAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDECIMALRule()); 
            }
            pushFollow(FOLLOW_ruleDECIMAL_in_entryRuleDECIMAL6170);
            iv_ruleDECIMAL=ruleDECIMAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDECIMAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDECIMAL6181); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDECIMAL"


    // $ANTLR start "ruleDECIMAL"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2797:1: ruleDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2800:28: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ) ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2801:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ) )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2801:1: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2801:2: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2801:2: (kw= '-' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==66) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2802:2: kw= '-'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleDECIMAL6220); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECIMALAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDECIMAL6237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_1, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_1()); 
                  
            }
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2814:1: (kw= '.' this_INT_3= RULE_INT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2815:2: kw= '.' this_INT_3= RULE_INT
            {
            kw=(Token)match(input,70,FOLLOW_70_in_ruleDECIMAL6256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getDECIMALAccess().getFullStopKeyword_2_0()); 
                  
            }
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDECIMAL6271); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_3);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_3, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_2_1()); 
                  
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDECIMAL"


    // $ANTLR start "entryRuleINTEGER"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2835:1: entryRuleINTEGER returns [String current=null] : iv_ruleINTEGER= ruleINTEGER EOF ;
    public final String entryRuleINTEGER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER = null;


        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2836:2: (iv_ruleINTEGER= ruleINTEGER EOF )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2837:2: iv_ruleINTEGER= ruleINTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleINTEGER_in_entryRuleINTEGER6318);
            iv_ruleINTEGER=ruleINTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTEGER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER6329); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTEGER"


    // $ANTLR start "ruleINTEGER"
    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2844:1: ruleINTEGER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleINTEGER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2847:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2848:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2848:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2848:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2848:2: (kw= '-' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==66) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2849:2: kw= '-'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleINTEGER6368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getINTEGERAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleINTEGER6385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_1, grammarAccess.getINTEGERAccess().getINTTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTEGER"

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\2\uffff\1\11\10\uffff";
    static final String DFA20_minS =
        "\1\5\1\12\1\4\10\uffff";
    static final String DFA20_maxS =
        "\1\102\1\12\1\106\10\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\2";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\1\4\1\5\1\6\1\7\1\2\47\uffff\1\10\17\uffff\1\1",
            "\1\2",
            "\1\11\15\uffff\1\11\6\uffff\1\11\1\uffff\1\11\6\uffff\4\11"+
            "\2\uffff\12\11\1\uffff\1\11\3\uffff\2\11\15\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1453:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (lv_value_15_0= '?' ) ) ) )";
        }
    }
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\2\uffff\1\12\10\uffff";
    static final String DFA37_minS =
        "\1\4\1\12\1\4\10\uffff";
    static final String DFA37_maxS =
        "\1\102\1\12\1\106\10\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\2\1\1";
    static final String DFA37_specialS =
        "\13\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\10\1\5\1\3\1\4\1\6\1\7\1\2\67\uffff\1\1",
            "\1\2",
            "\1\12\15\uffff\1\12\6\uffff\1\12\10\uffff\5\12\1\uffff\7\12"+
            "\4\uffff\1\12\1\uffff\1\12\1\uffff\2\12\1\uffff\13\12\1\uffff"+
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2586:1: ( ( () ( (lv_value_1_0= ruleINTEGER ) ) ) | ( () ( (lv_value_3_0= ruleDECIMAL ) ) ) | ( () ( (lv_value_5_0= RULE_STRING ) ) ) | ( () ( (lv_value_7_0= RULE_ENUM_ELEMENT ) ) ) | ( () ( (lv_value_9_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_value_11_0= RULE_BIT ) ) ) | ( () ( (lv_value_13_0= RULE_HEX ) ) ) | ( () ( (otherlv_15= RULE_IDENT ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleLANGUAGE_in_entryRuleLANGUAGE75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLANGUAGE85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMODULE_DECL_in_ruleLANGUAGE130 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleMODULE_DECL_in_entryRuleMODULE_DECL166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMODULE_DECL176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMODULE_DECL213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleMODULE_DECL239 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMODULE_DECL256 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleSTRATEGY_in_ruleMODULE_DECL277 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleINTERFACE_in_ruleMODULE_DECL298 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleBODY_in_ruleMODULE_DECL319 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMODULE_DECL331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTRATEGY_in_entryRuleSTRATEGY367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRATEGY377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSTRATEGY414 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSTRATEGY426 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSTRATEGY447 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ruleCRITERION_DECL_in_ruleSTRATEGY468 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleDATASEL_DECL_in_ruleSTRATEGY489 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSTRATEGY501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTERFACE_in_entryRuleINTERFACE537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTERFACE547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleINTERFACE584 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleINTERFACE596 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleINTERFACE617 = new BitSet(new long[]{0x00007F3C00000000L});
    public static final BitSet FOLLOW_ruleAbstractVAR_DECL_in_ruleINTERFACE638 = new BitSet(new long[]{0x00007F3C00040000L});
    public static final BitSet FOLLOW_18_in_ruleINTERFACE651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBODY_in_entryRuleBODY687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBODY697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBODY734 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleBODY746 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBODY767 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_ruleSTATEMENT_in_ruleBODY788 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_18_in_ruleBODY801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCRITERION_DECL_in_entryRuleCRITERION_DECL837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCRITERION_DECL847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleCRITERION_DECL884 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleCRITERION_DECL896 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_ruleCRITERION_in_ruleCRITERION_DECL926 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleCRITERION_DECL939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDATASEL_DECL_in_entryRuleDATASEL_DECL977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDATASEL_DECL987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDATASEL_DECL1024 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDATASEL_DECL1036 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_ruleDATASEL_in_ruleDATASEL_DECL1066 = new BitSet(new long[]{0x000000000A000002L});
    public static final BitSet FOLLOW_27_in_ruleDATASEL_DECL1079 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_ruleDATASEL_in_ruleDATASEL_DECL1100 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleDATASEL_DECL1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCRITERION_in_entryRuleCRITERION1153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCRITERION1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleCRITERION1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCRITERION1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleCRITERION1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDATASEL_in_entryRuleDATASEL1316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDATASEL1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDATASEL1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDATASEL1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDATASEL1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractVAR_DECL_in_entryRuleAbstractVAR_DECL1479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractVAR_DECL1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVAR_DECL_in_ruleAbstractVAR_DECL1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTmpVAR_DECL_in_ruleAbstractVAR_DECL1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCST_DECL_in_ruleAbstractVAR_DECL1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVAR_DECL_in_entryRuleVAR_DECL1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVAR_DECL1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlow_in_ruleVAR_DECL1690 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleVAR_DECL1707 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleVAR_DECL1724 = new BitSet(new long[]{0x00007F0000000000L});
    public static final BitSet FOLLOW_ruleTYPE_in_ruleVAR_DECL1745 = new BitSet(new long[]{0x0001800002020002L});
    public static final BitSet FOLLOW_ruleRANGE_in_ruleVAR_DECL1766 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleVAR_DECL1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlow_in_entryRuleFlow1818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlow1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFlow1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFlow1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleFlow1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCST_DECL_in_entryRuleCST_DECL1981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCST_DECL1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleCST_DECL2043 = new BitSet(new long[]{0x00007F0000000000L});
    public static final BitSet FOLLOW_ruleTYPE_in_ruleCST_DECL2077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleCST_DECL2094 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCST_DECL2111 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleCST_DECL2132 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleCST_DECL2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTmpVAR_DECL_in_entryRuleTmpVAR_DECL2183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTmpVAR_DECL2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTYPE_in_ruleTmpVAR_DECL2248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleTmpVAR_DECL2265 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleTmpVAR_DECL2282 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_ruleTmpVAR_DECL2303 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleTmpVAR_DECL2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTYPE_in_entryRuleTYPE2354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTYPE2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTYPE2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTYPE2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleTYPE2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTYPE2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTYPE2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleTYPE2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTYPE2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRANGE_in_entryRuleRANGE2633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRANGE2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTERVAL_in_ruleRANGE2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLSET_in_ruleRANGE2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTERVAL_in_entryRuleINTERVAL2752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTERVAL2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleINTERVAL2807 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_ruleINTERVAL2836 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleINTERVAL2873 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleINTERVAL2885 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleINTERVAL2906 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_ruleINTERVAL2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleINTERVAL2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLSET_in_entryRuleLSET3007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLSET3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleLSET3054 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLSET3084 = new BitSet(new long[]{0x0000000008040000L});
    public static final BitSet FOLLOW_27_in_ruleLSET3097 = new BitSet(new long[]{0x00040000000007E0L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleLSET3118 = new BitSet(new long[]{0x0000000008040000L});
    public static final BitSet FOLLOW_18_in_ruleLSET3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleLiteral3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECIMAL_in_ruleLiteral3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleLiteral3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteral3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENUM_ELEMENT_in_ruleLiteral3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIT_in_ruleLiteral3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleLiteral3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLiteral3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTATEMENT_in_entryRuleSTATEMENT3552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTATEMENT3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractVAR_DECL_in_ruleSTATEMENT3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIF_STATEMENT_in_ruleSTATEMENT3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOOP_STATEMENT_in_ruleSTATEMENT3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASSIGN_STATEMENT_in_ruleSTATEMENT3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERROR_STATEMENT_in_ruleSTATEMENT3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIF_STATEMENT_in_entryRuleIF_STATEMENT3752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIF_STATEMENT3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleIF_STATEMENT3799 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleIF_STATEMENT3811 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_ruleIF_STATEMENT3832 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleIF_STATEMENT3844 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIF_STATEMENT3856 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_ruleSTATEMENT_in_ruleIF_STATEMENT3877 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_18_in_ruleIF_STATEMENT3890 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleIF_STATEMENT3911 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIF_STATEMENT3924 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_ruleSTATEMENT_in_ruleIF_STATEMENT3945 = new BitSet(new long[]{0x01887F3C00040010L});
    public static final BitSet FOLLOW_18_in_ruleIF_STATEMENT3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOOP_STATEMENT_in_entryRuleLOOP_STATEMENT3995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLOOP_STATEMENT4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleLOOP_STATEMENT4042 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleLOOP_STATEMENT4054 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_ruleLOOP_STATEMENT4075 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleLOOP_STATEMENT4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleERROR_STATEMENT_in_entryRuleERROR_STATEMENT4123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleERROR_STATEMENT4133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleERROR_STATEMENT4170 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleERROR_STATEMENT4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASSIGN_STATEMENT_in_entryRuleASSIGN_STATEMENT4230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASSIGN_STATEMENT4240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVAR_REF_in_ruleASSIGN_STATEMENT4286 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleASSIGN_STATEMENT4298 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_ruleASSIGN_STATEMENT4319 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleASSIGN_STATEMENT4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVAR_REF_in_entryRuleVAR_REF4370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVAR_REF4380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleVAR_REF4424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_entryRuleEXPRESSION4459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEXPRESSION4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOR_in_ruleEXPRESSION4515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOR_in_entryRuleOR4549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOR4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAND_in_ruleOR4606 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleOR4627 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleAND_in_ruleOR4648 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_ruleAND_in_entryRuleAND4686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAND4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEQUAL_DIFF_in_ruleAND4743 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAND4764 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEQUAL_DIFF_in_ruleAND4785 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleEQUAL_DIFF_in_entryRuleEQUAL_DIFF4823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEQUAL_DIFF4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCOMPARISON_in_ruleEQUAL_DIFF4880 = new BitSet(new long[]{0x1000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleEQUAL_DIFF4909 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_60_in_ruleEQUAL_DIFF4938 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleCOMPARISON_in_ruleEQUAL_DIFF4975 = new BitSet(new long[]{0x1000004000000002L});
    public static final BitSet FOLLOW_ruleCOMPARISON_in_entryRuleCOMPARISON5013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCOMPARISON5023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADD_SUB_in_ruleCOMPARISON5070 = new BitSet(new long[]{0xE000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_61_in_ruleCOMPARISON5099 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_62_in_ruleCOMPARISON5128 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_63_in_ruleCOMPARISON5157 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_64_in_ruleCOMPARISON5186 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleADD_SUB_in_ruleCOMPARISON5223 = new BitSet(new long[]{0xE000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleADD_SUB_in_entryRuleADD_SUB5261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADD_SUB5271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMULT_DIV_in_ruleADD_SUB5318 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_65_in_ruleADD_SUB5341 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_66_in_ruleADD_SUB5370 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleMULT_DIV_in_ruleADD_SUB5393 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_ruleMULT_DIV_in_entryRuleMULT_DIV5431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMULT_DIV5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleMULT_DIV5488 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_67_in_ruleMULT_DIV5511 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_68_in_ruleMULT_DIV5540 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleMULT_DIV5563 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression5601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression5611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulePrimaryExpression5649 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_ruleEXPRESSION_in_rulePrimaryExpression5671 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_rulePrimaryExpression5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_rulePrimaryExpression5711 = new BitSet(new long[]{0x00100000000007F0L,0x0000000000000024L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePrimaryExpression5732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rulePrimaryExpression5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic5796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleAtomic5862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECIMAL_in_ruleAtomic5900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomic5934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ENUM_ELEMENT_in_ruleAtomic5973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleAtomic6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIT_in_ruleAtomic6051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleAtomic6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDENT_in_ruleAtomic6132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECIMAL_in_entryRuleDECIMAL6170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDECIMAL6181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleDECIMAL6220 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDECIMAL6237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleDECIMAL6256 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDECIMAL6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_entryRuleINTEGER6318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER6329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleINTEGER6368 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleINTEGER6385 = new BitSet(new long[]{0x0000000000000002L});

}