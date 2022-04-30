/* Generated By:JavaCC: Do not edit this line. CompilaBob.java */
public class CompilaBob implements CompilaBobConstants {
        String errormsg="\n";
        public static void main(String args[])  {
                CompilaBob compilador = new CompilaBob(System.in);
                try {
                        compilador.Codigo();
                }catch( Exception e ){
                        System.out.println( "Expresi\u00c3\u00b3n no v\u00c3\u00a1lida" );
                }
                catch( TokenMgrError e ) {
                        System.out.println( "Error de Token" );
                }
                System.out.println(compilador.errormsg);
                //System.out.println("Análisis Léxico ejecutado con éxito ! :D ---------------");
                 System.out.println("An"+"\u00e1"+"lisis l"+"\u00e9"+"xico ejecutado con "+"\u00e9"+"xito");
        }

  final public void Codigo() throws ParseException {
    jj_consume_token(INICIO);
    jj_consume_token(SepIzq);
    Cuerpo();
    jj_consume_token(ParenDer);
    jj_consume_token(FIN);
    jj_consume_token(0);
  }

  final public void Cuerpo() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CicloIterado:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      if (jj_2_1(3)) {
        sentencias();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case UNKNOW:
          error();
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void sentencias() throws ParseException {
    if (jj_2_2(2)) {
      Declaracion();
      jj_consume_token(PuntoComa);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        Asignacion();
        jj_consume_token(PuntoComa);
        break;
      case CicloIterado:
        Ciclo_RepitoHastaQue();
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Ciclo_RepitoHastaQue() throws ParseException {
    jj_consume_token(CicloIterado);
    jj_consume_token(ParenIzq);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(COMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case CADENAS:
    case NUMERO:
    case NUMDECIMAL:
    case EST_LOGIC:
      DataType();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ParenDer);
    jj_consume_token(ASIGNACION);
    jj_consume_token(SepIzq);
    sentencias();
    jj_consume_token(SepDer);
  }

  final public void Declaracion() throws ParseException {
    Variable_dato();
    Asignacion();
  }

  final public void Asignacion() throws ParseException {
    if (jj_2_3(2147483647)) {
      jj_consume_token(IDENTIFICADOR);
      jj_consume_token(ASIGNACION);
      Expresion();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        jj_consume_token(ASIGNACION);
        jj_consume_token(LEER);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Expresion() throws ParseException {
    if (jj_2_6(2)) {
      if (jj_2_4(2147483647)) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CADENAS:
        case NUMERO:
        case NUMDECIMAL:
        case EST_LOGIC:
          DataType();
          break;
        case IDENTIFICADOR:
          jj_consume_token(IDENTIFICADOR);
          break;
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CADENAS:
        case NUMERO:
        case NUMDECIMAL:
        case EST_LOGIC:
        case IDENTIFICADOR:
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case CADENAS:
          case NUMERO:
          case NUMDECIMAL:
          case EST_LOGIC:
            DataType();
            break;
          case IDENTIFICADOR:
            jj_consume_token(IDENTIFICADOR);
            break;
          default:
            jj_la1[6] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          Operadores();
          Expresion();
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ParenIzq:
        if (jj_2_5(2147483647)) {
          jj_consume_token(ParenIzq);
          Expresion();
          jj_consume_token(ParenDer);
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ParenIzq:
            jj_consume_token(ParenIzq);
            Expresion();
            jj_consume_token(ParenDer);
            Operadores();
            Expresion();
            break;
          default:
            jj_la1[8] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void DataType() throws ParseException {
    if (jj_2_7(2147483647)) {
      jj_consume_token(NUMERO);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMDECIMAL:
        jj_consume_token(NUMDECIMAL);
        break;
      case EST_LOGIC:
        jj_consume_token(EST_LOGIC);
        break;
      case CADENAS:
        jj_consume_token(CADENAS);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Operadores() throws ParseException {
    if (jj_2_8(3)) {
      jj_consume_token(MAS);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MENOS:
        jj_consume_token(MENOS);
        break;
      case DIV:
        jj_consume_token(DIV);
        break;
      case MODULO:
        jj_consume_token(MODULO);
        break;
      case MULTI:
        jj_consume_token(MULTI);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Variable_dato() throws ParseException {
    if (jj_2_9(3)) {
      jj_consume_token(ENTERO);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOTANTE:
        jj_consume_token(FLOTANTE);
        break;
      case ID_CADENA:
        jj_consume_token(ID_CADENA);
        break;
      case BOOLEANO:
        jj_consume_token(BOOLEANO);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void error() throws ParseException {
        String errores = " ";
        int linea, colum;
        Token t;
    t = jj_consume_token(UNKNOW);
        linea = t.beginLine;
        colum = t.endColumn;
        errores = "Simbolo: " + t.image + " no reconocido en la l\u00c3\u00adnea "+String.valueOf(linea)+" columna "+String.valueOf(colum)+"\r\n";
        errormsg = errormsg+errores;
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_3_5() {
    if (jj_scan_token(ParenIzq)) return true;
    if (jj_3R_6()) return true;
    if (jj_scan_token(ParenDer)) return true;
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_scan_token(ParenIzq)) return true;
    if (jj_3R_6()) return true;
    if (jj_scan_token(ParenDer)) return true;
    if (jj_3R_5()) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_scan_token(ParenIzq)) return true;
    if (jj_3R_6()) return true;
    if (jj_scan_token(ParenDer)) return true;
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_4()) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) return true;
    }
    if (jj_3R_5()) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) return true;
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_2()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_3()) return true;
    return false;
  }

  private boolean jj_3R_2() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) return true;
    }
    if (jj_3R_5()) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) return true;
    }
    return false;
  }

  private boolean jj_3_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_7()) {
    jj_scanpos = xsp;
    if (jj_3R_8()) return true;
    }
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(ASIGNACION)) return true;
    if (jj_scan_token(LEER)) return true;
    return false;
  }

  private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(ASIGNACION)) return true;
    if (jj_scan_token(LEER)) return true;
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3_9() {
    if (jj_scan_token(ENTERO)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(ASIGNACION)) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) return true;
    }
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(NUMDECIMAL)) return true;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_scan_token(MAS)) return true;
    return false;
  }

  private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) {
    jj_scanpos = xsp;
    if (jj_scan_token(31)) {
    jj_scanpos = xsp;
    if (jj_scan_token(32)) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_3() {
    if (jj_3R_11()) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(CicloIterado)) return true;
    if (jj_scan_token(ParenIzq)) return true;
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(36)) {
    jj_scanpos = xsp;
    if (jj_scan_token(37)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(33)) return true;
    }
    }
    }
    return false;
  }

  /** Generated Token Manager. */
  public CompilaBobTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  /** Whether we are looking ahead. */
  private boolean jj_lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x100,0x0,0x100,0x0,0x0,0x0,0x0,0x0,0x2000,0x2000,0x0,0xe0000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x6cc,0x400,0x200,0x332,0x200,0x332,0x332,0x332,0x0,0x0,0x122,0x1,0xc8,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[9];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public CompilaBob(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CompilaBob(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompilaBobTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public CompilaBob(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new CompilaBobTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public CompilaBob(CompilaBobTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CompilaBobTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 9; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
