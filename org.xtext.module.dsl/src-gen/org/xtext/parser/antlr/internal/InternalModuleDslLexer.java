package org.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModuleDslLexer extends Lexer {
    public static final int T__68=68;
    public static final int RULE_BOOLEAN=5;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int RULE_ID=11;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
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
    public static final int T__32=32;
    public static final int RULE_STRING=6;
    public static final int T__33=33;
    public static final int T__71=71;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_IDENT=4;
    public static final int T__39=39;
    public static final int RULE_WS=14;
    public static final int RULE_BIT=8;

    // delegates
    // delegators

    public InternalModuleDslLexer() {;} 
    public InternalModuleDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalModuleDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:11:7: ( 'module' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:11:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:12:7: ( '{' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:13:7: ( '}' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:14:7: ( '@' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:14:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:15:7: ( 'strategy' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:15:9: 'strategy'
            {
            match("strategy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:16:7: ( 'interface' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:16:9: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:17:7: ( 'body' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:17:9: 'body'
            {
            match("body"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:18:7: ( 'crit' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:18:9: 'crit'
            {
            match("crit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:19:7: ( ':' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:19:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:20:7: ( ';' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:20:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:21:7: ( 'datasel' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:21:9: 'datasel'
            {
            match("datasel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:22:7: ( ',' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:22:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:23:7: ( 'mcdc' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:23:9: 'mcdc'
            {
            match("mcdc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:24:7: ( 'dc' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:24:9: 'dc'
            {
            match("dc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:25:7: ( 'cc' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:25:9: 'cc'
            {
            match("cc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:26:7: ( 'rand' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:26:9: 'rand'
            {
            match("rand"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:27:7: ( 'eqv' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:27:9: 'eqv'
            {
            match("eqv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:28:7: ( 'bv' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:28:9: 'bv'
            {
            match("bv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:29:7: ( 'in' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:29:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:30:7: ( 'out' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:30:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:31:7: ( 'inout' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:31:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:32:7: ( 'const' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:32:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:33:7: ( '==' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:33:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:34:7: ( 'init' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:34:9: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:35:7: ( 'int' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:35:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:36:7: ( 'real' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:36:9: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:37:7: ( 'bool' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:37:9: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:38:7: ( 'enum' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:38:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:39:7: ( 'bit' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:39:9: 'bit'
            {
            match("bit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:40:7: ( 'hex' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:40:9: 'hex'
            {
            match("hex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:41:7: ( 'str' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:41:9: 'str'
            {
            match("str"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:42:7: ( ']' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:42:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:43:7: ( '[' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:43:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:44:7: ( '..' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:44:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:45:7: ( '?' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:45:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:46:7: ( 'if' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:46:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:47:7: ( '(' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:47:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:48:7: ( ')' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:48:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:49:7: ( 'else' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:49:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:50:7: ( 'loop' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:50:9: 'loop'
            {
            match("loop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:51:7: ( 'error' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:51:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:52:7: ( '=' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:52:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:53:7: ( 'or' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:53:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:54:7: ( 'and' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:54:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:55:7: ( '!=' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:55:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:56:7: ( '<' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:56:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:57:7: ( '<=' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:57:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:58:7: ( '>' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:58:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:59:7: ( '>=' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:59:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:60:7: ( '+' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:60:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:61:7: ( '-' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:61:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:62:7: ( '*' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:62:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:63:7: ( '/' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:63:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:64:7: ( '%' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:64:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:65:7: ( 'not' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:65:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:66:7: ( '.' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:66:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "RULE_ENUM_ELEMENT"
    public final void mRULE_ENUM_ELEMENT() throws RecognitionException {
        try {
            int _type = RULE_ENUM_ELEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2952:19: ( '_' RULE_IDENT )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2952:21: '_' RULE_IDENT
            {
            match('_'); 
            mRULE_IDENT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ENUM_ELEMENT"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2954:14: ( ( 'true' | 'false' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2954:16: ( 'true' | 'false' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2954:16: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2954:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2954:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2956:10: ( '0x' ( '0' .. '9' | 'A' .. 'F' )+ )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2956:12: '0x' ( '0' .. '9' | 'A' .. 'F' )+
            {
            match("0x"); 

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2956:17: ( '0' .. '9' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_IDENT"
    public final void mRULE_IDENT() throws RecognitionException {
        try {
            int _type = RULE_IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2958:12: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2958:14: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2958:34: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDENT"

    // $ANTLR start "RULE_BIT"
    public final void mRULE_BIT() throws RecognitionException {
        try {
            int _type = RULE_BIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2960:10: ( '0b' ( '0' | '1' )+ )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2960:12: '0b' ( '0' | '1' )+
            {
            match("0b"); 

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2960:17: ( '0' | '1' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='1')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2962:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2962:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2962:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2962:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2962:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2964:10: ( ( '0' .. '9' )+ )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2964:12: ( '0' .. '9' )+
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2964:12: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2964:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2966:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2968:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2968:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2968:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2968:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:40: ( ( '\\r' )? '\\n' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\n'||LA14_0=='\r') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:41: ( '\\r' )? '\\n'
                    {
                    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:41: ( '\\r' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='\r') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2970:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2972:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2972:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2972:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2974:16: ( . )
            // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:2974:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | RULE_ENUM_ELEMENT | RULE_BOOLEAN | RULE_HEX | RULE_IDENT | RULE_BIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt16=68;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:238: T__54
                {
                mT__54(); 

                }
                break;
            case 40 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:244: T__55
                {
                mT__55(); 

                }
                break;
            case 41 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:250: T__56
                {
                mT__56(); 

                }
                break;
            case 42 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:256: T__57
                {
                mT__57(); 

                }
                break;
            case 43 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:262: T__58
                {
                mT__58(); 

                }
                break;
            case 44 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:268: T__59
                {
                mT__59(); 

                }
                break;
            case 45 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:274: T__60
                {
                mT__60(); 

                }
                break;
            case 46 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:280: T__61
                {
                mT__61(); 

                }
                break;
            case 47 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:286: T__62
                {
                mT__62(); 

                }
                break;
            case 48 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:292: T__63
                {
                mT__63(); 

                }
                break;
            case 49 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:298: T__64
                {
                mT__64(); 

                }
                break;
            case 50 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:304: T__65
                {
                mT__65(); 

                }
                break;
            case 51 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:310: T__66
                {
                mT__66(); 

                }
                break;
            case 52 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:316: T__67
                {
                mT__67(); 

                }
                break;
            case 53 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:322: T__68
                {
                mT__68(); 

                }
                break;
            case 54 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:328: T__69
                {
                mT__69(); 

                }
                break;
            case 55 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:334: T__70
                {
                mT__70(); 

                }
                break;
            case 56 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:340: T__71
                {
                mT__71(); 

                }
                break;
            case 57 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:346: RULE_ENUM_ELEMENT
                {
                mRULE_ENUM_ELEMENT(); 

                }
                break;
            case 58 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:364: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 59 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:377: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 60 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:386: RULE_IDENT
                {
                mRULE_IDENT(); 

                }
                break;
            case 61 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:397: RULE_BIT
                {
                mRULE_BIT(); 

                }
                break;
            case 62 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:406: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 63 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:414: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 64 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:423: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 65 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:435: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 66 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:451: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 67 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:467: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 68 :
                // ../org.xtext.module.dsl/src-gen/org/xtext/parser/antlr/internal/InternalModuleDsl.g:1:475: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\1\uffff\1\60\3\uffff\4\60\2\uffff\1\60\1\uffff\3\60\1\114\1\60"+
        "\2\uffff\1\121\3\uffff\2\60\1\55\1\131\1\133\3\uffff\1\141\1\uffff"+
        "\1\60\1\145\2\60\1\152\1\60\1\55\1\uffff\2\55\2\uffff\2\60\1\uffff"+
        "\1\60\3\uffff\1\60\1\163\1\164\1\60\1\167\2\60\1\172\1\60\2\uffff"+
        "\1\60\1\175\1\uffff\7\60\1\u0085\2\uffff\1\60\7\uffff\2\60\14\uffff"+
        "\1\60\1\u008b\1\uffff\2\60\5\uffff\2\60\1\u0091\1\u0093\2\60\2\uffff"+
        "\2\60\1\uffff\1\u0098\1\60\1\uffff\2\60\1\uffff\2\60\1\u009e\3\60"+
        "\1\u00a2\1\uffff\1\u00a3\1\60\1\u00a5\1\u00a6\1\u008b\1\uffff\3"+
        "\60\1\u00aa\1\60\1\uffff\1\60\1\uffff\1\60\1\u00ae\1\u00af\1\u00b0"+
        "\1\uffff\1\u00b1\2\60\1\u00b4\1\u00b5\1\uffff\1\u00b6\1\u00b7\1"+
        "\60\2\uffff\1\u00b9\2\uffff\1\u00ba\2\60\1\uffff\2\60\1\u00bf\4"+
        "\uffff\1\u00c0\1\60\4\uffff\1\u00c2\2\uffff\1\u00ba\1\u00c3\2\60"+
        "\2\uffff\1\60\2\uffff\2\60\1\u00c9\1\u00ca\1\60\2\uffff\1\u00cc"+
        "\1\uffff";
    static final String DFA16_eofS =
        "\u00cd\uffff";
    static final String DFA16_minS =
        "\1\0\1\60\3\uffff\4\60\2\uffff\1\60\1\uffff\3\60\1\75\1\60\2\uffff"+
        "\1\56\3\uffff\2\60\3\75\3\uffff\1\52\1\uffff\1\60\1\101\2\60\1\142"+
        "\1\60\1\101\1\uffff\2\0\2\uffff\2\60\1\uffff\1\60\3\uffff\11\60"+
        "\2\uffff\2\60\1\uffff\10\60\2\uffff\1\60\7\uffff\2\60\14\uffff\2"+
        "\60\1\uffff\2\60\5\uffff\6\60\2\uffff\2\60\1\uffff\2\60\1\uffff"+
        "\2\60\1\uffff\7\60\1\uffff\5\60\1\uffff\5\60\1\uffff\1\60\1\uffff"+
        "\4\60\1\uffff\5\60\1\uffff\3\60\2\uffff\1\60\2\uffff\3\60\1\uffff"+
        "\3\60\4\uffff\2\60\4\uffff\1\60\2\uffff\4\60\2\uffff\1\60\2\uffff"+
        "\5\60\2\uffff\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\uffff\1\172\3\uffff\4\172\2\uffff\1\172\1\uffff\3\172\1\75\1"+
        "\172\2\uffff\1\56\3\uffff\2\172\3\75\3\uffff\1\57\1\uffff\4\172"+
        "\1\170\2\172\1\uffff\2\uffff\2\uffff\2\172\1\uffff\1\172\3\uffff"+
        "\11\172\2\uffff\2\172\1\uffff\10\172\2\uffff\1\172\7\uffff\2\172"+
        "\14\uffff\2\172\1\uffff\2\172\5\uffff\6\172\2\uffff\2\172\1\uffff"+
        "\2\172\1\uffff\2\172\1\uffff\7\172\1\uffff\5\172\1\uffff\5\172\1"+
        "\uffff\1\172\1\uffff\4\172\1\uffff\5\172\1\uffff\3\172\2\uffff\1"+
        "\172\2\uffff\3\172\1\uffff\3\172\4\uffff\2\172\4\uffff\1\172\2\uffff"+
        "\4\172\2\uffff\1\172\2\uffff\5\172\2\uffff\1\172\1\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\1\4\4\uffff\1\11\1\12\1\uffff\1\14\5\uffff\1\40"+
        "\1\41\1\uffff\1\43\1\45\1\46\5\uffff\1\62\1\63\1\64\1\uffff\1\66"+
        "\7\uffff\1\77\2\uffff\1\103\1\104\2\uffff\1\74\1\uffff\1\2\1\3\1"+
        "\4\11\uffff\1\11\1\12\2\uffff\1\14\10\uffff\1\27\1\52\1\uffff\1"+
        "\40\1\41\1\42\1\70\1\43\1\45\1\46\2\uffff\1\55\1\57\1\56\1\61\1"+
        "\60\1\62\1\63\1\64\1\101\1\102\1\65\1\66\2\uffff\1\76\2\uffff\1"+
        "\73\1\75\1\77\1\100\1\103\6\uffff\1\23\1\44\2\uffff\1\22\2\uffff"+
        "\1\17\2\uffff\1\16\7\uffff\1\53\5\uffff\1\71\5\uffff\1\37\1\uffff"+
        "\1\31\4\uffff\1\35\5\uffff\1\21\3\uffff\1\24\1\36\1\uffff\1\54\1"+
        "\67\3\uffff\1\15\3\uffff\1\30\1\7\1\33\1\10\2\uffff\1\20\1\32\1"+
        "\34\1\47\1\uffff\1\50\1\72\4\uffff\1\25\1\26\1\uffff\1\51\1\1\5"+
        "\uffff\1\13\1\5\1\uffff\1\6";
    static final String DFA16_specialS =
        "\1\2\51\uffff\1\1\1\0\u00a1\uffff}>";
    static final String[] DFA16_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\32\1\52\2\55\1\41\1\55\1"+
            "\53\1\26\1\27\1\37\1\35\1\14\1\36\1\24\1\40\1\46\11\51\1\11"+
            "\1\12\1\33\1\20\1\34\1\25\1\4\32\47\1\23\1\55\1\22\1\50\1\43"+
            "\1\55\1\31\1\7\1\10\1\13\1\16\1\45\1\47\1\21\1\6\2\47\1\30\1"+
            "\1\1\42\1\17\2\47\1\15\1\5\1\44\6\47\1\2\1\55\1\3\uff82\55",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\2\61\1\57\13\61"+
            "\1\56\13\61",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\65\6\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\5\61\1\67\7\61\1"+
            "\66\14\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\10\61\1\72\5\61"+
            "\1\70\6\61\1\71\4\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\2\61\1\74\13\61"+
            "\1\75\2\61\1\73\10\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\100\1\61\1\101"+
            "\27\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\103\3\61\1\104"+
            "\25\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\107\1\61"+
            "\1\106\2\61\1\105\1\110\10\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\112\2\61"+
            "\1\111\5\61",
            "\1\113",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\115\25\61",
            "",
            "",
            "\1\120",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\16\61\1\125\13\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\15\61\1\126\14\61",
            "\1\127",
            "\1\130",
            "\1\132",
            "",
            "",
            "",
            "\1\137\4\uffff\1\140",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\16\61\1\143\13\61",
            "\32\144\6\uffff\32\144",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\146\10\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\147\31\61",
            "\1\151\25\uffff\1\150",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\32\145\4\uffff\1\145\1\uffff\32\145",
            "",
            "\0\153",
            "\0\153",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\3\61\1\155\26\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\3\61\1\156\26\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\157\10\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\10\61\1\162\5\61"+
            "\1\161\4\61\1\160\6\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\3\61\1\165\12\61"+
            "\1\166\13\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\170\6\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\10\61\1\171\21\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\15\61\1\173\14\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\174\6\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\15\61\1\176\14\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\177\31\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\25\61\1\u0080\4"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\24\61\1\u0081\5"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22\61\1\u0082\7"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\u0083\10"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u0084\6"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\27\61\1\u0086\2"+
            "\61",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\16\61\1\u0087\13"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\3\61\1\u0088\26"+
            "\61",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u0089\6"+
            "\61",
            "\12\u008a\7\uffff\32\u008a\4\uffff\1\u008a\1\uffff\32\u008a",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\24\61\1\u008c\5"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\u008d\16"+
            "\61",
            "",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\24\61\1\u008e\5"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\2\61\1\u008f\27"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\u0090\31\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u0092\25"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\24\61\1\u0094\5"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u0095\6"+
            "\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\30\61\1\u0096\1"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\u0097\16"+
            "\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u0099\6"+
            "\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22\61\1\u009a\7"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\u009b\31\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\3\61\1\u009c\26"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\u009d\16"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\14\61\1\u009f\15"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00a0\25"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\16\61\1\u00a1\13"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\17\61\1\u00a4\12"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\u008a\7\uffff\32\u008a\4\uffff\1\u008a\1\uffff\32\u008a",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00a7\25"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22\61\1\u00a8\7"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\u00a9\16"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u00ab\6"+
            "\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\u00ac\10"+
            "\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u00ad\6"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\23\61\1\u00b2\6"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\22\61\1\u00b3\7"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\21\61\1\u00b8\10"+
            "\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00bb\25"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00bc\25"+
            "\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00bd\25"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\5\61\1\u00be\24"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00c1\25"+
            "\61",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\6\61\1\u00c4\23"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\1\u00c5\31\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\13\61\1\u00c6\16"+
            "\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\30\61\1\u00c7\1"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\2\61\1\u00c8\27"+
            "\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\4\61\1\u00cb\25"+
            "\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | RULE_ENUM_ELEMENT | RULE_BOOLEAN | RULE_HEX | RULE_IDENT | RULE_BIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_43 = input.LA(1);

                        s = -1;
                        if ( ((LA16_43>='\u0000' && LA16_43<='\uFFFF')) ) {s = 107;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_42 = input.LA(1);

                        s = -1;
                        if ( ((LA16_42>='\u0000' && LA16_42<='\uFFFF')) ) {s = 107;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_0 = input.LA(1);

                        s = -1;
                        if ( (LA16_0=='m') ) {s = 1;}

                        else if ( (LA16_0=='{') ) {s = 2;}

                        else if ( (LA16_0=='}') ) {s = 3;}

                        else if ( (LA16_0=='@') ) {s = 4;}

                        else if ( (LA16_0=='s') ) {s = 5;}

                        else if ( (LA16_0=='i') ) {s = 6;}

                        else if ( (LA16_0=='b') ) {s = 7;}

                        else if ( (LA16_0=='c') ) {s = 8;}

                        else if ( (LA16_0==':') ) {s = 9;}

                        else if ( (LA16_0==';') ) {s = 10;}

                        else if ( (LA16_0=='d') ) {s = 11;}

                        else if ( (LA16_0==',') ) {s = 12;}

                        else if ( (LA16_0=='r') ) {s = 13;}

                        else if ( (LA16_0=='e') ) {s = 14;}

                        else if ( (LA16_0=='o') ) {s = 15;}

                        else if ( (LA16_0=='=') ) {s = 16;}

                        else if ( (LA16_0=='h') ) {s = 17;}

                        else if ( (LA16_0==']') ) {s = 18;}

                        else if ( (LA16_0=='[') ) {s = 19;}

                        else if ( (LA16_0=='.') ) {s = 20;}

                        else if ( (LA16_0=='?') ) {s = 21;}

                        else if ( (LA16_0=='(') ) {s = 22;}

                        else if ( (LA16_0==')') ) {s = 23;}

                        else if ( (LA16_0=='l') ) {s = 24;}

                        else if ( (LA16_0=='a') ) {s = 25;}

                        else if ( (LA16_0=='!') ) {s = 26;}

                        else if ( (LA16_0=='<') ) {s = 27;}

                        else if ( (LA16_0=='>') ) {s = 28;}

                        else if ( (LA16_0=='+') ) {s = 29;}

                        else if ( (LA16_0=='-') ) {s = 30;}

                        else if ( (LA16_0=='*') ) {s = 31;}

                        else if ( (LA16_0=='/') ) {s = 32;}

                        else if ( (LA16_0=='%') ) {s = 33;}

                        else if ( (LA16_0=='n') ) {s = 34;}

                        else if ( (LA16_0=='_') ) {s = 35;}

                        else if ( (LA16_0=='t') ) {s = 36;}

                        else if ( (LA16_0=='f') ) {s = 37;}

                        else if ( (LA16_0=='0') ) {s = 38;}

                        else if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='g'||(LA16_0>='j' && LA16_0<='k')||(LA16_0>='p' && LA16_0<='q')||(LA16_0>='u' && LA16_0<='z')) ) {s = 39;}

                        else if ( (LA16_0=='^') ) {s = 40;}

                        else if ( ((LA16_0>='1' && LA16_0<='9')) ) {s = 41;}

                        else if ( (LA16_0=='\"') ) {s = 42;}

                        else if ( (LA16_0=='\'') ) {s = 43;}

                        else if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {s = 44;}

                        else if ( ((LA16_0>='\u0000' && LA16_0<='\b')||(LA16_0>='\u000B' && LA16_0<='\f')||(LA16_0>='\u000E' && LA16_0<='\u001F')||(LA16_0>='#' && LA16_0<='$')||LA16_0=='&'||LA16_0=='\\'||LA16_0=='`'||LA16_0=='|'||(LA16_0>='~' && LA16_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}