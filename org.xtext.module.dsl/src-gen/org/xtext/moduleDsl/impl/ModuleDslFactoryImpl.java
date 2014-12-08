/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.moduleDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModuleDslFactoryImpl extends EFactoryImpl implements ModuleDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleDslFactory init()
  {
    try
    {
      ModuleDslFactory theModuleDslFactory = (ModuleDslFactory)EPackage.Registry.INSTANCE.getEFactory(ModuleDslPackage.eNS_URI);
      if (theModuleDslFactory != null)
      {
        return theModuleDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModuleDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ModuleDslPackage.LANGUAGE: return createLANGUAGE();
      case ModuleDslPackage.MODULE_DECL: return createMODULE_DECL();
      case ModuleDslPackage.STRATEGY: return createSTRATEGY();
      case ModuleDslPackage.INTERFACE: return createINTERFACE();
      case ModuleDslPackage.BODY: return createBODY();
      case ModuleDslPackage.CRITERION_DECL: return createCRITERION_DECL();
      case ModuleDslPackage.DATASEL_DECL: return createDATASEL_DECL();
      case ModuleDslPackage.CRITERION: return createCRITERION();
      case ModuleDslPackage.DATASEL: return createDATASEL();
      case ModuleDslPackage.ABSTRACT_VAR_DECL: return createAbstractVAR_DECL();
      case ModuleDslPackage.VAR_DECL: return createVAR_DECL();
      case ModuleDslPackage.FLOW: return createFlow();
      case ModuleDslPackage.CST_DECL: return createCST_DECL();
      case ModuleDslPackage.TMP_VAR_DECL: return createTmpVAR_DECL();
      case ModuleDslPackage.TYPE: return createTYPE();
      case ModuleDslPackage.RANGE: return createRANGE();
      case ModuleDslPackage.INTERVAL: return createINTERVAL();
      case ModuleDslPackage.LSET: return createLSET();
      case ModuleDslPackage.LITERAL: return createLiteral();
      case ModuleDslPackage.STATEMENT: return createSTATEMENT();
      case ModuleDslPackage.IF_STATEMENT: return createIF_STATEMENT();
      case ModuleDslPackage.LOOP_STATEMENT: return createLOOP_STATEMENT();
      case ModuleDslPackage.ERROR_STATEMENT: return createERROR_STATEMENT();
      case ModuleDslPackage.ASSIGN_STATEMENT: return createASSIGN_STATEMENT();
      case ModuleDslPackage.VAR_REF: return createVAR_REF();
      case ModuleDslPackage.EXPRESSION: return createEXPRESSION();
      case ModuleDslPackage.INT_LITERAL: return createintLITERAL();
      case ModuleDslPackage.REAL_LITERAL: return createrealLITERAL();
      case ModuleDslPackage.BOOL_LITERAL: return createboolLITERAL();
      case ModuleDslPackage.STR_LITERAL: return createstrLITERAL();
      case ModuleDslPackage.ENUM_LITERAL: return createenumLITERAL();
      case ModuleDslPackage.BIT_LITERAL: return createbitLITERAL();
      case ModuleDslPackage.HEX_LITERAL: return createhexLITERAL();
      case ModuleDslPackage.UNKNOW_LITERAL: return createunknowLITERAL();
      case ModuleDslPackage.OR: return createOR();
      case ModuleDslPackage.AND: return createAND();
      case ModuleDslPackage.EQUAL_DIFF: return createEQUAL_DIFF();
      case ModuleDslPackage.COMPARISON: return createCOMPARISON();
      case ModuleDslPackage.ADD: return createADD();
      case ModuleDslPackage.SUB: return createSUB();
      case ModuleDslPackage.MULT: return createMULT();
      case ModuleDslPackage.DIV: return createDIV();
      case ModuleDslPackage.NOT: return createNOT();
      case ModuleDslPackage.INT_CONSTANT: return createintConstant();
      case ModuleDslPackage.REAL_CONSTANT: return createrealConstant();
      case ModuleDslPackage.STR_CONSTANT: return createstrConstant();
      case ModuleDslPackage.ENUM_CONSTANT: return createenumConstant();
      case ModuleDslPackage.BOOL_CONSTANT: return createboolConstant();
      case ModuleDslPackage.BIT_CONSTANT: return createbitConstant();
      case ModuleDslPackage.HEX_CONSTANT: return createhexConstant();
      case ModuleDslPackage.VAR_EXP_REF: return createVarExpRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LANGUAGE createLANGUAGE()
  {
    LANGUAGEImpl language = new LANGUAGEImpl();
    return language;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MODULE_DECL createMODULE_DECL()
  {
    MODULE_DECLImpl modulE_DECL = new MODULE_DECLImpl();
    return modulE_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STRATEGY createSTRATEGY()
  {
    STRATEGYImpl strategy = new STRATEGYImpl();
    return strategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTERFACE createINTERFACE()
  {
    INTERFACEImpl interface_ = new INTERFACEImpl();
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BODY createBODY()
  {
    BODYImpl body = new BODYImpl();
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CRITERION_DECL createCRITERION_DECL()
  {
    CRITERION_DECLImpl criterioN_DECL = new CRITERION_DECLImpl();
    return criterioN_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DATASEL_DECL createDATASEL_DECL()
  {
    DATASEL_DECLImpl dataseL_DECL = new DATASEL_DECLImpl();
    return dataseL_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CRITERION createCRITERION()
  {
    CRITERIONImpl criterion = new CRITERIONImpl();
    return criterion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DATASEL createDATASEL()
  {
    DATASELImpl datasel = new DATASELImpl();
    return datasel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVAR_DECL createAbstractVAR_DECL()
  {
    AbstractVAR_DECLImpl abstractVAR_DECL = new AbstractVAR_DECLImpl();
    return abstractVAR_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VAR_DECL createVAR_DECL()
  {
    VAR_DECLImpl vaR_DECL = new VAR_DECLImpl();
    return vaR_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Flow createFlow()
  {
    FlowImpl flow = new FlowImpl();
    return flow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CST_DECL createCST_DECL()
  {
    CST_DECLImpl csT_DECL = new CST_DECLImpl();
    return csT_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TmpVAR_DECL createTmpVAR_DECL()
  {
    TmpVAR_DECLImpl tmpVAR_DECL = new TmpVAR_DECLImpl();
    return tmpVAR_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TYPE createTYPE()
  {
    TYPEImpl type = new TYPEImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RANGE createRANGE()
  {
    RANGEImpl range = new RANGEImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public INTERVAL createINTERVAL()
  {
    INTERVALImpl interval = new INTERVALImpl();
    return interval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LSET createLSET()
  {
    LSETImpl lset = new LSETImpl();
    return lset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STATEMENT createSTATEMENT()
  {
    STATEMENTImpl statement = new STATEMENTImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IF_STATEMENT createIF_STATEMENT()
  {
    IF_STATEMENTImpl iF_STATEMENT = new IF_STATEMENTImpl();
    return iF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LOOP_STATEMENT createLOOP_STATEMENT()
  {
    LOOP_STATEMENTImpl looP_STATEMENT = new LOOP_STATEMENTImpl();
    return looP_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ERROR_STATEMENT createERROR_STATEMENT()
  {
    ERROR_STATEMENTImpl erroR_STATEMENT = new ERROR_STATEMENTImpl();
    return erroR_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASSIGN_STATEMENT createASSIGN_STATEMENT()
  {
    ASSIGN_STATEMENTImpl assigN_STATEMENT = new ASSIGN_STATEMENTImpl();
    return assigN_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VAR_REF createVAR_REF()
  {
    VAR_REFImpl vaR_REF = new VAR_REFImpl();
    return vaR_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EXPRESSION createEXPRESSION()
  {
    EXPRESSIONImpl expression = new EXPRESSIONImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public intLITERAL createintLITERAL()
  {
    intLITERALImpl intLITERAL = new intLITERALImpl();
    return intLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public realLITERAL createrealLITERAL()
  {
    realLITERALImpl realLITERAL = new realLITERALImpl();
    return realLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolLITERAL createboolLITERAL()
  {
    boolLITERALImpl boolLITERAL = new boolLITERALImpl();
    return boolLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public strLITERAL createstrLITERAL()
  {
    strLITERALImpl strLITERAL = new strLITERALImpl();
    return strLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public enumLITERAL createenumLITERAL()
  {
    enumLITERALImpl enumLITERAL = new enumLITERALImpl();
    return enumLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public bitLITERAL createbitLITERAL()
  {
    bitLITERALImpl bitLITERAL = new bitLITERALImpl();
    return bitLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public hexLITERAL createhexLITERAL()
  {
    hexLITERALImpl hexLITERAL = new hexLITERALImpl();
    return hexLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public unknowLITERAL createunknowLITERAL()
  {
    unknowLITERALImpl unknowLITERAL = new unknowLITERALImpl();
    return unknowLITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OR createOR()
  {
    ORImpl or = new ORImpl();
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AND createAND()
  {
    ANDImpl and = new ANDImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EQUAL_DIFF createEQUAL_DIFF()
  {
    EQUAL_DIFFImpl equaL_DIFF = new EQUAL_DIFFImpl();
    return equaL_DIFF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public COMPARISON createCOMPARISON()
  {
    COMPARISONImpl comparison = new COMPARISONImpl();
    return comparison;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ADD createADD()
  {
    ADDImpl add = new ADDImpl();
    return add;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SUB createSUB()
  {
    SUBImpl sub = new SUBImpl();
    return sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MULT createMULT()
  {
    MULTImpl mult = new MULTImpl();
    return mult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DIV createDIV()
  {
    DIVImpl div = new DIVImpl();
    return div;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NOT createNOT()
  {
    NOTImpl not = new NOTImpl();
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public intConstant createintConstant()
  {
    intConstantImpl intConstant = new intConstantImpl();
    return intConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public realConstant createrealConstant()
  {
    realConstantImpl realConstant = new realConstantImpl();
    return realConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public strConstant createstrConstant()
  {
    strConstantImpl strConstant = new strConstantImpl();
    return strConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public enumConstant createenumConstant()
  {
    enumConstantImpl enumConstant = new enumConstantImpl();
    return enumConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolConstant createboolConstant()
  {
    boolConstantImpl boolConstant = new boolConstantImpl();
    return boolConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public bitConstant createbitConstant()
  {
    bitConstantImpl bitConstant = new bitConstantImpl();
    return bitConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public hexConstant createhexConstant()
  {
    hexConstantImpl hexConstant = new hexConstantImpl();
    return hexConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarExpRef createVarExpRef()
  {
    VarExpRefImpl varExpRef = new VarExpRefImpl();
    return varExpRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleDslPackage getModuleDslPackage()
  {
    return (ModuleDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ModuleDslPackage getPackage()
  {
    return ModuleDslPackage.eINSTANCE;
  }

} //ModuleDslFactoryImpl
