/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.moduleDsl.ModuleDslFactory
 * @model kind="package"
 * @generated
 */
public interface ModuleDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "moduleDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/ModuleDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "moduleDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModuleDslPackage eINSTANCE = org.xtext.moduleDsl.impl.ModuleDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.LANGUAGEImpl <em>LANGUAGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.LANGUAGEImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLANGUAGE()
   * @generated
   */
  int LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE__MODULES = 0;

  /**
   * The number of structural features of the '<em>LANGUAGE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.MODULE_DECLImpl <em>MODULE DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.MODULE_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getMODULE_DECL()
   * @generated
   */
  int MODULE_DECL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Strategy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_DECL__STRATEGY = 1;

  /**
   * The feature id for the '<em><b>Interface</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_DECL__INTERFACE = 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_DECL__BODY = 3;

  /**
   * The number of structural features of the '<em>MODULE DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_DECL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.STRATEGYImpl <em>STRATEGY</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.STRATEGYImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSTRATEGY()
   * @generated
   */
  int STRATEGY = 2;

  /**
   * The feature id for the '<em><b>Critdecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__CRITDECL = 0;

  /**
   * The feature id for the '<em><b>Dataseldecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY__DATASELDECL = 1;

  /**
   * The number of structural features of the '<em>STRATEGY</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.INTERFACEImpl <em>INTERFACE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.INTERFACEImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getINTERFACE()
   * @generated
   */
  int INTERFACE = 3;

  /**
   * The feature id for the '<em><b>Declaration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE__DECLARATION = 0;

  /**
   * The number of structural features of the '<em>INTERFACE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.BODYImpl <em>BODY</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.BODYImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getBODY()
   * @generated
   */
  int BODY = 4;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>BODY</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.CRITERION_DECLImpl <em>CRITERION DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.CRITERION_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCRITERION_DECL()
   * @generated
   */
  int CRITERION_DECL = 5;

  /**
   * The feature id for the '<em><b>Crit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CRITERION_DECL__CRIT = 0;

  /**
   * The number of structural features of the '<em>CRITERION DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CRITERION_DECL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.DATASEL_DECLImpl <em>DATASEL DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.DATASEL_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDATASEL_DECL()
   * @generated
   */
  int DATASEL_DECL = 6;

  /**
   * The feature id for the '<em><b>Data1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATASEL_DECL__DATA1 = 0;

  /**
   * The feature id for the '<em><b>Data2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATASEL_DECL__DATA2 = 1;

  /**
   * The number of structural features of the '<em>DATASEL DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATASEL_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.CRITERIONImpl <em>CRITERION</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.CRITERIONImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCRITERION()
   * @generated
   */
  int CRITERION = 7;

  /**
   * The feature id for the '<em><b>Crit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CRITERION__CRIT = 0;

  /**
   * The number of structural features of the '<em>CRITERION</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CRITERION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.DATASELImpl <em>DATASEL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.DATASELImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDATASEL()
   * @generated
   */
  int DATASEL = 8;

  /**
   * The feature id for the '<em><b>Sel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATASEL__SEL = 0;

  /**
   * The number of structural features of the '<em>DATASEL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATASEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.STATEMENTImpl <em>STATEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.STATEMENTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSTATEMENT()
   * @generated
   */
  int STATEMENT = 19;

  /**
   * The number of structural features of the '<em>STATEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.AbstractVAR_DECLImpl <em>Abstract VAR DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.AbstractVAR_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getAbstractVAR_DECL()
   * @generated
   */
  int ABSTRACT_VAR_DECL = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VAR_DECL__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VAR_DECL__TYPE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Abstract VAR DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VAR_DECL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.VAR_DECLImpl <em>VAR DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.VAR_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVAR_DECL()
   * @generated
   */
  int VAR_DECL = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__NAME = ABSTRACT_VAR_DECL__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__TYPE = ABSTRACT_VAR_DECL__TYPE;

  /**
   * The feature id for the '<em><b>Flow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__FLOW = ABSTRACT_VAR_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__RANGE = ABSTRACT_VAR_DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>VAR DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL_FEATURE_COUNT = ABSTRACT_VAR_DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.FlowImpl <em>Flow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.FlowImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getFlow()
   * @generated
   */
  int FLOW = 11;

  /**
   * The feature id for the '<em><b>Flow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOW__FLOW = 0;

  /**
   * The number of structural features of the '<em>Flow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOW_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.CST_DECLImpl <em>CST DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.CST_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCST_DECL()
   * @generated
   */
  int CST_DECL = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CST_DECL__NAME = ABSTRACT_VAR_DECL__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CST_DECL__TYPE = ABSTRACT_VAR_DECL__TYPE;

  /**
   * The feature id for the '<em><b>Flow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CST_DECL__FLOW = ABSTRACT_VAR_DECL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CST_DECL__VALUE = ABSTRACT_VAR_DECL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>CST DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CST_DECL_FEATURE_COUNT = ABSTRACT_VAR_DECL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.TmpVAR_DECLImpl <em>Tmp VAR DECL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.TmpVAR_DECLImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getTmpVAR_DECL()
   * @generated
   */
  int TMP_VAR_DECL = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMP_VAR_DECL__NAME = ABSTRACT_VAR_DECL__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMP_VAR_DECL__TYPE = ABSTRACT_VAR_DECL__TYPE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMP_VAR_DECL__VALUE = ABSTRACT_VAR_DECL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tmp VAR DECL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TMP_VAR_DECL_FEATURE_COUNT = ABSTRACT_VAR_DECL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.TYPEImpl <em>TYPE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.TYPEImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getTYPE()
   * @generated
   */
  int TYPE = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE = 0;

  /**
   * The number of structural features of the '<em>TYPE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.RANGEImpl <em>RANGE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.RANGEImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getRANGE()
   * @generated
   */
  int RANGE = 15;

  /**
   * The number of structural features of the '<em>RANGE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.INTERVALImpl <em>INTERVAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.INTERVALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getINTERVAL()
   * @generated
   */
  int INTERVAL = 16;

  /**
   * The feature id for the '<em><b>Lsqbr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__LSQBR = RANGE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__MIN = RANGE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__MAX = RANGE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Rsqbr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__RSQBR = RANGE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>INTERVAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_FEATURE_COUNT = RANGE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.LSETImpl <em>LSET</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.LSETImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLSET()
   * @generated
   */
  int LSET = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSET__VALUE = RANGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LSET</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LSET_FEATURE_COUNT = RANGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.LiteralImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 18;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.IF_STATEMENTImpl <em>IF STATEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.IF_STATEMENTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getIF_STATEMENT()
   * @generated
   */
  int IF_STATEMENT = 20;

  /**
   * The feature id for the '<em><b>If Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__IF_COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ifst</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__IFST = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Elst</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELST = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>IF STATEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.LOOP_STATEMENTImpl <em>LOOP STATEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.LOOP_STATEMENTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLOOP_STATEMENT()
   * @generated
   */
  int LOOP_STATEMENT = 21;

  /**
   * The feature id for the '<em><b>Loop Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT__LOOP_COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>LOOP STATEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.ERROR_STATEMENTImpl <em>ERROR STATEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.ERROR_STATEMENTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getERROR_STATEMENT()
   * @generated
   */
  int ERROR_STATEMENT = 22;

  /**
   * The number of structural features of the '<em>ERROR STATEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.ASSIGN_STATEMENTImpl <em>ASSIGN STATEMENT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.ASSIGN_STATEMENTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getASSIGN_STATEMENT()
   * @generated
   */
  int ASSIGN_STATEMENT = 23;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT__LEFT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT__RIGHT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ASSIGN STATEMENT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.VAR_REFImpl <em>VAR REF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.VAR_REFImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVAR_REF()
   * @generated
   */
  int VAR_REF = 24;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_REF__VARIABLE = 0;

  /**
   * The number of structural features of the '<em>VAR REF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.EXPRESSIONImpl <em>EXPRESSION</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.EXPRESSIONImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getEXPRESSION()
   * @generated
   */
  int EXPRESSION = 25;

  /**
   * The number of structural features of the '<em>EXPRESSION</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.intLITERALImpl <em>int LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.intLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getintLITERAL()
   * @generated
   */
  int INT_LITERAL = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>int LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.realLITERALImpl <em>real LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.realLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getrealLITERAL()
   * @generated
   */
  int REAL_LITERAL = 27;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>real LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.boolLITERALImpl <em>bool LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.boolLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getboolLITERAL()
   * @generated
   */
  int BOOL_LITERAL = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>bool LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.strLITERALImpl <em>str LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.strLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getstrLITERAL()
   * @generated
   */
  int STR_LITERAL = 29;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STR_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>str LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STR_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.enumLITERALImpl <em>enum LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.enumLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getenumLITERAL()
   * @generated
   */
  int ENUM_LITERAL = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>enum LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.bitLITERALImpl <em>bit LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.bitLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getbitLITERAL()
   * @generated
   */
  int BIT_LITERAL = 31;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>bit LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.hexLITERALImpl <em>hex LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.hexLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#gethexLITERAL()
   * @generated
   */
  int HEX_LITERAL = 32;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>hex LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.unknowLITERALImpl <em>unknow LITERAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.unknowLITERALImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getunknowLITERAL()
   * @generated
   */
  int UNKNOW_LITERAL = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNKNOW_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>unknow LITERAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNKNOW_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.ORImpl <em>OR</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.ORImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getOR()
   * @generated
   */
  int OR = 34;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>OR</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.ANDImpl <em>AND</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.ANDImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getAND()
   * @generated
   */
  int AND = 35;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AND</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.EQUAL_DIFFImpl <em>EQUAL DIFF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.EQUAL_DIFFImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getEQUAL_DIFF()
   * @generated
   */
  int EQUAL_DIFF = 36;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_DIFF__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_DIFF__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_DIFF__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>EQUAL DIFF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_DIFF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.COMPARISONImpl <em>COMPARISON</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.COMPARISONImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCOMPARISON()
   * @generated
   */
  int COMPARISON = 37;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>COMPARISON</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.ADDImpl <em>ADD</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.ADDImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getADD()
   * @generated
   */
  int ADD = 38;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ADD</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.SUBImpl <em>SUB</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.SUBImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSUB()
   * @generated
   */
  int SUB = 39;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>SUB</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.MULTImpl <em>MULT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.MULTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getMULT()
   * @generated
   */
  int MULT = 40;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MULT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.DIVImpl <em>DIV</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.DIVImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDIV()
   * @generated
   */
  int DIV = 41;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>DIV</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.NOTImpl <em>NOT</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.NOTImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getNOT()
   * @generated
   */
  int NOT = 42;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT__EXP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>NOT</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.intConstantImpl <em>int Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.intConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getintConstant()
   * @generated
   */
  int INT_CONSTANT = 43;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>int Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.realConstantImpl <em>real Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.realConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getrealConstant()
   * @generated
   */
  int REAL_CONSTANT = 44;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>real Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.strConstantImpl <em>str Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.strConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getstrConstant()
   * @generated
   */
  int STR_CONSTANT = 45;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STR_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>str Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STR_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.enumConstantImpl <em>enum Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.enumConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getenumConstant()
   * @generated
   */
  int ENUM_CONSTANT = 46;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>enum Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.boolConstantImpl <em>bool Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.boolConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getboolConstant()
   * @generated
   */
  int BOOL_CONSTANT = 47;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>bool Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.bitConstantImpl <em>bit Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.bitConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getbitConstant()
   * @generated
   */
  int BIT_CONSTANT = 48;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>bit Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.hexConstantImpl <em>hex Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.hexConstantImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#gethexConstant()
   * @generated
   */
  int HEX_CONSTANT = 49;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>hex Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.moduleDsl.impl.VarExpRefImpl <em>Var Exp Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.moduleDsl.impl.VarExpRefImpl
   * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVarExpRef()
   * @generated
   */
  int VAR_EXP_REF = 50;

  /**
   * The feature id for the '<em><b>Vref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_EXP_REF__VREF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Var Exp Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_EXP_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.LANGUAGE <em>LANGUAGE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LANGUAGE</em>'.
   * @see org.xtext.moduleDsl.LANGUAGE
   * @generated
   */
  EClass getLANGUAGE();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.LANGUAGE#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see org.xtext.moduleDsl.LANGUAGE#getModules()
   * @see #getLANGUAGE()
   * @generated
   */
  EReference getLANGUAGE_Modules();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.MODULE_DECL <em>MODULE DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MODULE DECL</em>'.
   * @see org.xtext.moduleDsl.MODULE_DECL
   * @generated
   */
  EClass getMODULE_DECL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.MODULE_DECL#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.moduleDsl.MODULE_DECL#getName()
   * @see #getMODULE_DECL()
   * @generated
   */
  EAttribute getMODULE_DECL_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.MODULE_DECL#getStrategy <em>Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Strategy</em>'.
   * @see org.xtext.moduleDsl.MODULE_DECL#getStrategy()
   * @see #getMODULE_DECL()
   * @generated
   */
  EReference getMODULE_DECL_Strategy();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.MODULE_DECL#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Interface</em>'.
   * @see org.xtext.moduleDsl.MODULE_DECL#getInterface()
   * @see #getMODULE_DECL()
   * @generated
   */
  EReference getMODULE_DECL_Interface();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.MODULE_DECL#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.xtext.moduleDsl.MODULE_DECL#getBody()
   * @see #getMODULE_DECL()
   * @generated
   */
  EReference getMODULE_DECL_Body();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.STRATEGY <em>STRATEGY</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>STRATEGY</em>'.
   * @see org.xtext.moduleDsl.STRATEGY
   * @generated
   */
  EClass getSTRATEGY();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.STRATEGY#getCritdecl <em>Critdecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Critdecl</em>'.
   * @see org.xtext.moduleDsl.STRATEGY#getCritdecl()
   * @see #getSTRATEGY()
   * @generated
   */
  EReference getSTRATEGY_Critdecl();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.STRATEGY#getDataseldecl <em>Dataseldecl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dataseldecl</em>'.
   * @see org.xtext.moduleDsl.STRATEGY#getDataseldecl()
   * @see #getSTRATEGY()
   * @generated
   */
  EReference getSTRATEGY_Dataseldecl();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.INTERFACE <em>INTERFACE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>INTERFACE</em>'.
   * @see org.xtext.moduleDsl.INTERFACE
   * @generated
   */
  EClass getINTERFACE();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.INTERFACE#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declaration</em>'.
   * @see org.xtext.moduleDsl.INTERFACE#getDeclaration()
   * @see #getINTERFACE()
   * @generated
   */
  EReference getINTERFACE_Declaration();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.BODY <em>BODY</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>BODY</em>'.
   * @see org.xtext.moduleDsl.BODY
   * @generated
   */
  EClass getBODY();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.BODY#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.xtext.moduleDsl.BODY#getStatements()
   * @see #getBODY()
   * @generated
   */
  EReference getBODY_Statements();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.CRITERION_DECL <em>CRITERION DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CRITERION DECL</em>'.
   * @see org.xtext.moduleDsl.CRITERION_DECL
   * @generated
   */
  EClass getCRITERION_DECL();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.CRITERION_DECL#getCrit <em>Crit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Crit</em>'.
   * @see org.xtext.moduleDsl.CRITERION_DECL#getCrit()
   * @see #getCRITERION_DECL()
   * @generated
   */
  EReference getCRITERION_DECL_Crit();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.DATASEL_DECL <em>DATASEL DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DATASEL DECL</em>'.
   * @see org.xtext.moduleDsl.DATASEL_DECL
   * @generated
   */
  EClass getDATASEL_DECL();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.DATASEL_DECL#getData1 <em>Data1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data1</em>'.
   * @see org.xtext.moduleDsl.DATASEL_DECL#getData1()
   * @see #getDATASEL_DECL()
   * @generated
   */
  EReference getDATASEL_DECL_Data1();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.DATASEL_DECL#getData2 <em>Data2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data2</em>'.
   * @see org.xtext.moduleDsl.DATASEL_DECL#getData2()
   * @see #getDATASEL_DECL()
   * @generated
   */
  EReference getDATASEL_DECL_Data2();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.CRITERION <em>CRITERION</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CRITERION</em>'.
   * @see org.xtext.moduleDsl.CRITERION
   * @generated
   */
  EClass getCRITERION();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.CRITERION#getCrit <em>Crit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Crit</em>'.
   * @see org.xtext.moduleDsl.CRITERION#getCrit()
   * @see #getCRITERION()
   * @generated
   */
  EAttribute getCRITERION_Crit();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.DATASEL <em>DATASEL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DATASEL</em>'.
   * @see org.xtext.moduleDsl.DATASEL
   * @generated
   */
  EClass getDATASEL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.DATASEL#getSel <em>Sel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sel</em>'.
   * @see org.xtext.moduleDsl.DATASEL#getSel()
   * @see #getDATASEL()
   * @generated
   */
  EAttribute getDATASEL_Sel();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.AbstractVAR_DECL <em>Abstract VAR DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract VAR DECL</em>'.
   * @see org.xtext.moduleDsl.AbstractVAR_DECL
   * @generated
   */
  EClass getAbstractVAR_DECL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.AbstractVAR_DECL#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.moduleDsl.AbstractVAR_DECL#getName()
   * @see #getAbstractVAR_DECL()
   * @generated
   */
  EAttribute getAbstractVAR_DECL_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.AbstractVAR_DECL#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.moduleDsl.AbstractVAR_DECL#getType()
   * @see #getAbstractVAR_DECL()
   * @generated
   */
  EReference getAbstractVAR_DECL_Type();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.VAR_DECL <em>VAR DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>VAR DECL</em>'.
   * @see org.xtext.moduleDsl.VAR_DECL
   * @generated
   */
  EClass getVAR_DECL();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.VAR_DECL#getFlow <em>Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Flow</em>'.
   * @see org.xtext.moduleDsl.VAR_DECL#getFlow()
   * @see #getVAR_DECL()
   * @generated
   */
  EReference getVAR_DECL_Flow();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.VAR_DECL#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see org.xtext.moduleDsl.VAR_DECL#getRange()
   * @see #getVAR_DECL()
   * @generated
   */
  EReference getVAR_DECL_Range();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.Flow <em>Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Flow</em>'.
   * @see org.xtext.moduleDsl.Flow
   * @generated
   */
  EClass getFlow();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.Flow#getFlow <em>Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Flow</em>'.
   * @see org.xtext.moduleDsl.Flow#getFlow()
   * @see #getFlow()
   * @generated
   */
  EAttribute getFlow_Flow();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.CST_DECL <em>CST DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CST DECL</em>'.
   * @see org.xtext.moduleDsl.CST_DECL
   * @generated
   */
  EClass getCST_DECL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.CST_DECL#getFlow <em>Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Flow</em>'.
   * @see org.xtext.moduleDsl.CST_DECL#getFlow()
   * @see #getCST_DECL()
   * @generated
   */
  EAttribute getCST_DECL_Flow();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.CST_DECL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.xtext.moduleDsl.CST_DECL#getValue()
   * @see #getCST_DECL()
   * @generated
   */
  EReference getCST_DECL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.TmpVAR_DECL <em>Tmp VAR DECL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tmp VAR DECL</em>'.
   * @see org.xtext.moduleDsl.TmpVAR_DECL
   * @generated
   */
  EClass getTmpVAR_DECL();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.TmpVAR_DECL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.xtext.moduleDsl.TmpVAR_DECL#getValue()
   * @see #getTmpVAR_DECL()
   * @generated
   */
  EReference getTmpVAR_DECL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.TYPE <em>TYPE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TYPE</em>'.
   * @see org.xtext.moduleDsl.TYPE
   * @generated
   */
  EClass getTYPE();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.TYPE#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.xtext.moduleDsl.TYPE#getType()
   * @see #getTYPE()
   * @generated
   */
  EAttribute getTYPE_Type();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.RANGE <em>RANGE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RANGE</em>'.
   * @see org.xtext.moduleDsl.RANGE
   * @generated
   */
  EClass getRANGE();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.INTERVAL <em>INTERVAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>INTERVAL</em>'.
   * @see org.xtext.moduleDsl.INTERVAL
   * @generated
   */
  EClass getINTERVAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.INTERVAL#getLsqbr <em>Lsqbr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lsqbr</em>'.
   * @see org.xtext.moduleDsl.INTERVAL#getLsqbr()
   * @see #getINTERVAL()
   * @generated
   */
  EAttribute getINTERVAL_Lsqbr();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.INTERVAL#getMin <em>Min</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Min</em>'.
   * @see org.xtext.moduleDsl.INTERVAL#getMin()
   * @see #getINTERVAL()
   * @generated
   */
  EReference getINTERVAL_Min();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.INTERVAL#getMax <em>Max</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Max</em>'.
   * @see org.xtext.moduleDsl.INTERVAL#getMax()
   * @see #getINTERVAL()
   * @generated
   */
  EReference getINTERVAL_Max();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.INTERVAL#getRsqbr <em>Rsqbr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rsqbr</em>'.
   * @see org.xtext.moduleDsl.INTERVAL#getRsqbr()
   * @see #getINTERVAL()
   * @generated
   */
  EAttribute getINTERVAL_Rsqbr();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.LSET <em>LSET</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LSET</em>'.
   * @see org.xtext.moduleDsl.LSET
   * @generated
   */
  EClass getLSET();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.LSET#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see org.xtext.moduleDsl.LSET#getValue()
   * @see #getLSET()
   * @generated
   */
  EReference getLSET_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.xtext.moduleDsl.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.STATEMENT <em>STATEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>STATEMENT</em>'.
   * @see org.xtext.moduleDsl.STATEMENT
   * @generated
   */
  EClass getSTATEMENT();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.IF_STATEMENT <em>IF STATEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>IF STATEMENT</em>'.
   * @see org.xtext.moduleDsl.IF_STATEMENT
   * @generated
   */
  EClass getIF_STATEMENT();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.IF_STATEMENT#getIfCond <em>If Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Cond</em>'.
   * @see org.xtext.moduleDsl.IF_STATEMENT#getIfCond()
   * @see #getIF_STATEMENT()
   * @generated
   */
  EReference getIF_STATEMENT_IfCond();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.IF_STATEMENT#getIfst <em>Ifst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ifst</em>'.
   * @see org.xtext.moduleDsl.IF_STATEMENT#getIfst()
   * @see #getIF_STATEMENT()
   * @generated
   */
  EReference getIF_STATEMENT_Ifst();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.moduleDsl.IF_STATEMENT#getElst <em>Elst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elst</em>'.
   * @see org.xtext.moduleDsl.IF_STATEMENT#getElst()
   * @see #getIF_STATEMENT()
   * @generated
   */
  EReference getIF_STATEMENT_Elst();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.LOOP_STATEMENT <em>LOOP STATEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LOOP STATEMENT</em>'.
   * @see org.xtext.moduleDsl.LOOP_STATEMENT
   * @generated
   */
  EClass getLOOP_STATEMENT();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.LOOP_STATEMENT#getLoopCond <em>Loop Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Loop Cond</em>'.
   * @see org.xtext.moduleDsl.LOOP_STATEMENT#getLoopCond()
   * @see #getLOOP_STATEMENT()
   * @generated
   */
  EReference getLOOP_STATEMENT_LoopCond();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.ERROR_STATEMENT <em>ERROR STATEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ERROR STATEMENT</em>'.
   * @see org.xtext.moduleDsl.ERROR_STATEMENT
   * @generated
   */
  EClass getERROR_STATEMENT();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.ASSIGN_STATEMENT <em>ASSIGN STATEMENT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASSIGN STATEMENT</em>'.
   * @see org.xtext.moduleDsl.ASSIGN_STATEMENT
   * @generated
   */
  EClass getASSIGN_STATEMENT();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.ASSIGN_STATEMENT#getLeft()
   * @see #getASSIGN_STATEMENT()
   * @generated
   */
  EReference getASSIGN_STATEMENT_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.ASSIGN_STATEMENT#getRight()
   * @see #getASSIGN_STATEMENT()
   * @generated
   */
  EReference getASSIGN_STATEMENT_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.VAR_REF <em>VAR REF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>VAR REF</em>'.
   * @see org.xtext.moduleDsl.VAR_REF
   * @generated
   */
  EClass getVAR_REF();

  /**
   * Returns the meta object for the reference '{@link org.xtext.moduleDsl.VAR_REF#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.xtext.moduleDsl.VAR_REF#getVariable()
   * @see #getVAR_REF()
   * @generated
   */
  EReference getVAR_REF_Variable();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.EXPRESSION <em>EXPRESSION</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EXPRESSION</em>'.
   * @see org.xtext.moduleDsl.EXPRESSION
   * @generated
   */
  EClass getEXPRESSION();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.intLITERAL <em>int LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>int LITERAL</em>'.
   * @see org.xtext.moduleDsl.intLITERAL
   * @generated
   */
  EClass getintLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.intLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.intLITERAL#getValue()
   * @see #getintLITERAL()
   * @generated
   */
  EAttribute getintLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.realLITERAL <em>real LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>real LITERAL</em>'.
   * @see org.xtext.moduleDsl.realLITERAL
   * @generated
   */
  EClass getrealLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.realLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.realLITERAL#getValue()
   * @see #getrealLITERAL()
   * @generated
   */
  EAttribute getrealLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.boolLITERAL <em>bool LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>bool LITERAL</em>'.
   * @see org.xtext.moduleDsl.boolLITERAL
   * @generated
   */
  EClass getboolLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.boolLITERAL#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.boolLITERAL#isValue()
   * @see #getboolLITERAL()
   * @generated
   */
  EAttribute getboolLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.strLITERAL <em>str LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>str LITERAL</em>'.
   * @see org.xtext.moduleDsl.strLITERAL
   * @generated
   */
  EClass getstrLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.strLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.strLITERAL#getValue()
   * @see #getstrLITERAL()
   * @generated
   */
  EAttribute getstrLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.enumLITERAL <em>enum LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>enum LITERAL</em>'.
   * @see org.xtext.moduleDsl.enumLITERAL
   * @generated
   */
  EClass getenumLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.enumLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.enumLITERAL#getValue()
   * @see #getenumLITERAL()
   * @generated
   */
  EAttribute getenumLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.bitLITERAL <em>bit LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>bit LITERAL</em>'.
   * @see org.xtext.moduleDsl.bitLITERAL
   * @generated
   */
  EClass getbitLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.bitLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.bitLITERAL#getValue()
   * @see #getbitLITERAL()
   * @generated
   */
  EAttribute getbitLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.hexLITERAL <em>hex LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>hex LITERAL</em>'.
   * @see org.xtext.moduleDsl.hexLITERAL
   * @generated
   */
  EClass gethexLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.hexLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.hexLITERAL#getValue()
   * @see #gethexLITERAL()
   * @generated
   */
  EAttribute gethexLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.unknowLITERAL <em>unknow LITERAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unknow LITERAL</em>'.
   * @see org.xtext.moduleDsl.unknowLITERAL
   * @generated
   */
  EClass getunknowLITERAL();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.unknowLITERAL#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.unknowLITERAL#getValue()
   * @see #getunknowLITERAL()
   * @generated
   */
  EAttribute getunknowLITERAL_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.OR <em>OR</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>OR</em>'.
   * @see org.xtext.moduleDsl.OR
   * @generated
   */
  EClass getOR();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.OR#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.OR#getLeft()
   * @see #getOR()
   * @generated
   */
  EReference getOR_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.OR#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.OR#getRight()
   * @see #getOR()
   * @generated
   */
  EReference getOR_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.AND <em>AND</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AND</em>'.
   * @see org.xtext.moduleDsl.AND
   * @generated
   */
  EClass getAND();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.AND#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.AND#getLeft()
   * @see #getAND()
   * @generated
   */
  EReference getAND_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.AND#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.AND#getRight()
   * @see #getAND()
   * @generated
   */
  EReference getAND_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.EQUAL_DIFF <em>EQUAL DIFF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EQUAL DIFF</em>'.
   * @see org.xtext.moduleDsl.EQUAL_DIFF
   * @generated
   */
  EClass getEQUAL_DIFF();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.EQUAL_DIFF#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.EQUAL_DIFF#getLeft()
   * @see #getEQUAL_DIFF()
   * @generated
   */
  EReference getEQUAL_DIFF_Left();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.EQUAL_DIFF#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.xtext.moduleDsl.EQUAL_DIFF#getOp()
   * @see #getEQUAL_DIFF()
   * @generated
   */
  EAttribute getEQUAL_DIFF_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.EQUAL_DIFF#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.EQUAL_DIFF#getRight()
   * @see #getEQUAL_DIFF()
   * @generated
   */
  EReference getEQUAL_DIFF_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.COMPARISON <em>COMPARISON</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>COMPARISON</em>'.
   * @see org.xtext.moduleDsl.COMPARISON
   * @generated
   */
  EClass getCOMPARISON();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.COMPARISON#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.COMPARISON#getLeft()
   * @see #getCOMPARISON()
   * @generated
   */
  EReference getCOMPARISON_Left();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.COMPARISON#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.xtext.moduleDsl.COMPARISON#getOp()
   * @see #getCOMPARISON()
   * @generated
   */
  EAttribute getCOMPARISON_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.COMPARISON#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.COMPARISON#getRight()
   * @see #getCOMPARISON()
   * @generated
   */
  EReference getCOMPARISON_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.ADD <em>ADD</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ADD</em>'.
   * @see org.xtext.moduleDsl.ADD
   * @generated
   */
  EClass getADD();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.ADD#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.ADD#getLeft()
   * @see #getADD()
   * @generated
   */
  EReference getADD_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.ADD#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.ADD#getRight()
   * @see #getADD()
   * @generated
   */
  EReference getADD_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.SUB <em>SUB</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SUB</em>'.
   * @see org.xtext.moduleDsl.SUB
   * @generated
   */
  EClass getSUB();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.SUB#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.SUB#getLeft()
   * @see #getSUB()
   * @generated
   */
  EReference getSUB_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.SUB#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.SUB#getRight()
   * @see #getSUB()
   * @generated
   */
  EReference getSUB_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.MULT <em>MULT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MULT</em>'.
   * @see org.xtext.moduleDsl.MULT
   * @generated
   */
  EClass getMULT();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.MULT#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.MULT#getLeft()
   * @see #getMULT()
   * @generated
   */
  EReference getMULT_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.MULT#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.MULT#getRight()
   * @see #getMULT()
   * @generated
   */
  EReference getMULT_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.DIV <em>DIV</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DIV</em>'.
   * @see org.xtext.moduleDsl.DIV
   * @generated
   */
  EClass getDIV();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.DIV#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.moduleDsl.DIV#getLeft()
   * @see #getDIV()
   * @generated
   */
  EReference getDIV_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.DIV#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.moduleDsl.DIV#getRight()
   * @see #getDIV()
   * @generated
   */
  EReference getDIV_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.NOT <em>NOT</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>NOT</em>'.
   * @see org.xtext.moduleDsl.NOT
   * @generated
   */
  EClass getNOT();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.moduleDsl.NOT#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.xtext.moduleDsl.NOT#getExp()
   * @see #getNOT()
   * @generated
   */
  EReference getNOT_Exp();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.intConstant <em>int Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>int Constant</em>'.
   * @see org.xtext.moduleDsl.intConstant
   * @generated
   */
  EClass getintConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.intConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.intConstant#getValue()
   * @see #getintConstant()
   * @generated
   */
  EAttribute getintConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.realConstant <em>real Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>real Constant</em>'.
   * @see org.xtext.moduleDsl.realConstant
   * @generated
   */
  EClass getrealConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.realConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.realConstant#getValue()
   * @see #getrealConstant()
   * @generated
   */
  EAttribute getrealConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.strConstant <em>str Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>str Constant</em>'.
   * @see org.xtext.moduleDsl.strConstant
   * @generated
   */
  EClass getstrConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.strConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.strConstant#getValue()
   * @see #getstrConstant()
   * @generated
   */
  EAttribute getstrConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.enumConstant <em>enum Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>enum Constant</em>'.
   * @see org.xtext.moduleDsl.enumConstant
   * @generated
   */
  EClass getenumConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.enumConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.enumConstant#getValue()
   * @see #getenumConstant()
   * @generated
   */
  EAttribute getenumConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.boolConstant <em>bool Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>bool Constant</em>'.
   * @see org.xtext.moduleDsl.boolConstant
   * @generated
   */
  EClass getboolConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.boolConstant#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.boolConstant#isValue()
   * @see #getboolConstant()
   * @generated
   */
  EAttribute getboolConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.bitConstant <em>bit Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>bit Constant</em>'.
   * @see org.xtext.moduleDsl.bitConstant
   * @generated
   */
  EClass getbitConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.bitConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.bitConstant#getValue()
   * @see #getbitConstant()
   * @generated
   */
  EAttribute getbitConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.hexConstant <em>hex Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>hex Constant</em>'.
   * @see org.xtext.moduleDsl.hexConstant
   * @generated
   */
  EClass gethexConstant();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.moduleDsl.hexConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.moduleDsl.hexConstant#getValue()
   * @see #gethexConstant()
   * @generated
   */
  EAttribute gethexConstant_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.moduleDsl.VarExpRef <em>Var Exp Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Exp Ref</em>'.
   * @see org.xtext.moduleDsl.VarExpRef
   * @generated
   */
  EClass getVarExpRef();

  /**
   * Returns the meta object for the reference '{@link org.xtext.moduleDsl.VarExpRef#getVref <em>Vref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Vref</em>'.
   * @see org.xtext.moduleDsl.VarExpRef#getVref()
   * @see #getVarExpRef()
   * @generated
   */
  EReference getVarExpRef_Vref();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ModuleDslFactory getModuleDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.LANGUAGEImpl <em>LANGUAGE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.LANGUAGEImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLANGUAGE()
     * @generated
     */
    EClass LANGUAGE = eINSTANCE.getLANGUAGE();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE__MODULES = eINSTANCE.getLANGUAGE_Modules();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.MODULE_DECLImpl <em>MODULE DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.MODULE_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getMODULE_DECL()
     * @generated
     */
    EClass MODULE_DECL = eINSTANCE.getMODULE_DECL();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE_DECL__NAME = eINSTANCE.getMODULE_DECL_Name();

    /**
     * The meta object literal for the '<em><b>Strategy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_DECL__STRATEGY = eINSTANCE.getMODULE_DECL_Strategy();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_DECL__INTERFACE = eINSTANCE.getMODULE_DECL_Interface();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_DECL__BODY = eINSTANCE.getMODULE_DECL_Body();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.STRATEGYImpl <em>STRATEGY</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.STRATEGYImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSTRATEGY()
     * @generated
     */
    EClass STRATEGY = eINSTANCE.getSTRATEGY();

    /**
     * The meta object literal for the '<em><b>Critdecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY__CRITDECL = eINSTANCE.getSTRATEGY_Critdecl();

    /**
     * The meta object literal for the '<em><b>Dataseldecl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY__DATASELDECL = eINSTANCE.getSTRATEGY_Dataseldecl();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.INTERFACEImpl <em>INTERFACE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.INTERFACEImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getINTERFACE()
     * @generated
     */
    EClass INTERFACE = eINSTANCE.getINTERFACE();

    /**
     * The meta object literal for the '<em><b>Declaration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE__DECLARATION = eINSTANCE.getINTERFACE_Declaration();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.BODYImpl <em>BODY</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.BODYImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getBODY()
     * @generated
     */
    EClass BODY = eINSTANCE.getBODY();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY__STATEMENTS = eINSTANCE.getBODY_Statements();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.CRITERION_DECLImpl <em>CRITERION DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.CRITERION_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCRITERION_DECL()
     * @generated
     */
    EClass CRITERION_DECL = eINSTANCE.getCRITERION_DECL();

    /**
     * The meta object literal for the '<em><b>Crit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CRITERION_DECL__CRIT = eINSTANCE.getCRITERION_DECL_Crit();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.DATASEL_DECLImpl <em>DATASEL DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.DATASEL_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDATASEL_DECL()
     * @generated
     */
    EClass DATASEL_DECL = eINSTANCE.getDATASEL_DECL();

    /**
     * The meta object literal for the '<em><b>Data1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATASEL_DECL__DATA1 = eINSTANCE.getDATASEL_DECL_Data1();

    /**
     * The meta object literal for the '<em><b>Data2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATASEL_DECL__DATA2 = eINSTANCE.getDATASEL_DECL_Data2();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.CRITERIONImpl <em>CRITERION</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.CRITERIONImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCRITERION()
     * @generated
     */
    EClass CRITERION = eINSTANCE.getCRITERION();

    /**
     * The meta object literal for the '<em><b>Crit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CRITERION__CRIT = eINSTANCE.getCRITERION_Crit();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.DATASELImpl <em>DATASEL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.DATASELImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDATASEL()
     * @generated
     */
    EClass DATASEL = eINSTANCE.getDATASEL();

    /**
     * The meta object literal for the '<em><b>Sel</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATASEL__SEL = eINSTANCE.getDATASEL_Sel();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.AbstractVAR_DECLImpl <em>Abstract VAR DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.AbstractVAR_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getAbstractVAR_DECL()
     * @generated
     */
    EClass ABSTRACT_VAR_DECL = eINSTANCE.getAbstractVAR_DECL();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_VAR_DECL__NAME = eINSTANCE.getAbstractVAR_DECL_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_VAR_DECL__TYPE = eINSTANCE.getAbstractVAR_DECL_Type();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.VAR_DECLImpl <em>VAR DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.VAR_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVAR_DECL()
     * @generated
     */
    EClass VAR_DECL = eINSTANCE.getVAR_DECL();

    /**
     * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECL__FLOW = eINSTANCE.getVAR_DECL_Flow();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECL__RANGE = eINSTANCE.getVAR_DECL_Range();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.FlowImpl <em>Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.FlowImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getFlow()
     * @generated
     */
    EClass FLOW = eINSTANCE.getFlow();

    /**
     * The meta object literal for the '<em><b>Flow</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOW__FLOW = eINSTANCE.getFlow_Flow();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.CST_DECLImpl <em>CST DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.CST_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCST_DECL()
     * @generated
     */
    EClass CST_DECL = eINSTANCE.getCST_DECL();

    /**
     * The meta object literal for the '<em><b>Flow</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CST_DECL__FLOW = eINSTANCE.getCST_DECL_Flow();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CST_DECL__VALUE = eINSTANCE.getCST_DECL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.TmpVAR_DECLImpl <em>Tmp VAR DECL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.TmpVAR_DECLImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getTmpVAR_DECL()
     * @generated
     */
    EClass TMP_VAR_DECL = eINSTANCE.getTmpVAR_DECL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TMP_VAR_DECL__VALUE = eINSTANCE.getTmpVAR_DECL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.TYPEImpl <em>TYPE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.TYPEImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getTYPE()
     * @generated
     */
    EClass TYPE = eINSTANCE.getTYPE();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPE = eINSTANCE.getTYPE_Type();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.RANGEImpl <em>RANGE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.RANGEImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getRANGE()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRANGE();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.INTERVALImpl <em>INTERVAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.INTERVALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getINTERVAL()
     * @generated
     */
    EClass INTERVAL = eINSTANCE.getINTERVAL();

    /**
     * The meta object literal for the '<em><b>Lsqbr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__LSQBR = eINSTANCE.getINTERVAL_Lsqbr();

    /**
     * The meta object literal for the '<em><b>Min</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__MIN = eINSTANCE.getINTERVAL_Min();

    /**
     * The meta object literal for the '<em><b>Max</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERVAL__MAX = eINSTANCE.getINTERVAL_Max();

    /**
     * The meta object literal for the '<em><b>Rsqbr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__RSQBR = eINSTANCE.getINTERVAL_Rsqbr();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.LSETImpl <em>LSET</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.LSETImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLSET()
     * @generated
     */
    EClass LSET = eINSTANCE.getLSET();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LSET__VALUE = eINSTANCE.getLSET_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.LiteralImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.STATEMENTImpl <em>STATEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.STATEMENTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSTATEMENT()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getSTATEMENT();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.IF_STATEMENTImpl <em>IF STATEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.IF_STATEMENTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getIF_STATEMENT()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIF_STATEMENT();

    /**
     * The meta object literal for the '<em><b>If Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__IF_COND = eINSTANCE.getIF_STATEMENT_IfCond();

    /**
     * The meta object literal for the '<em><b>Ifst</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__IFST = eINSTANCE.getIF_STATEMENT_Ifst();

    /**
     * The meta object literal for the '<em><b>Elst</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELST = eINSTANCE.getIF_STATEMENT_Elst();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.LOOP_STATEMENTImpl <em>LOOP STATEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.LOOP_STATEMENTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getLOOP_STATEMENT()
     * @generated
     */
    EClass LOOP_STATEMENT = eINSTANCE.getLOOP_STATEMENT();

    /**
     * The meta object literal for the '<em><b>Loop Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP_STATEMENT__LOOP_COND = eINSTANCE.getLOOP_STATEMENT_LoopCond();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.ERROR_STATEMENTImpl <em>ERROR STATEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.ERROR_STATEMENTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getERROR_STATEMENT()
     * @generated
     */
    EClass ERROR_STATEMENT = eINSTANCE.getERROR_STATEMENT();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.ASSIGN_STATEMENTImpl <em>ASSIGN STATEMENT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.ASSIGN_STATEMENTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getASSIGN_STATEMENT()
     * @generated
     */
    EClass ASSIGN_STATEMENT = eINSTANCE.getASSIGN_STATEMENT();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN_STATEMENT__LEFT = eINSTANCE.getASSIGN_STATEMENT_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN_STATEMENT__RIGHT = eINSTANCE.getASSIGN_STATEMENT_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.VAR_REFImpl <em>VAR REF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.VAR_REFImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVAR_REF()
     * @generated
     */
    EClass VAR_REF = eINSTANCE.getVAR_REF();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_REF__VARIABLE = eINSTANCE.getVAR_REF_Variable();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.EXPRESSIONImpl <em>EXPRESSION</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.EXPRESSIONImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getEXPRESSION()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getEXPRESSION();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.intLITERALImpl <em>int LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.intLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getintLITERAL()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getintLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__VALUE = eINSTANCE.getintLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.realLITERALImpl <em>real LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.realLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getrealLITERAL()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getrealLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL__VALUE = eINSTANCE.getrealLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.boolLITERALImpl <em>bool LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.boolLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getboolLITERAL()
     * @generated
     */
    EClass BOOL_LITERAL = eINSTANCE.getboolLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_LITERAL__VALUE = eINSTANCE.getboolLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.strLITERALImpl <em>str LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.strLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getstrLITERAL()
     * @generated
     */
    EClass STR_LITERAL = eINSTANCE.getstrLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STR_LITERAL__VALUE = eINSTANCE.getstrLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.enumLITERALImpl <em>enum LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.enumLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getenumLITERAL()
     * @generated
     */
    EClass ENUM_LITERAL = eINSTANCE.getenumLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_LITERAL__VALUE = eINSTANCE.getenumLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.bitLITERALImpl <em>bit LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.bitLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getbitLITERAL()
     * @generated
     */
    EClass BIT_LITERAL = eINSTANCE.getbitLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_LITERAL__VALUE = eINSTANCE.getbitLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.hexLITERALImpl <em>hex LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.hexLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#gethexLITERAL()
     * @generated
     */
    EClass HEX_LITERAL = eINSTANCE.gethexLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEX_LITERAL__VALUE = eINSTANCE.gethexLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.unknowLITERALImpl <em>unknow LITERAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.unknowLITERALImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getunknowLITERAL()
     * @generated
     */
    EClass UNKNOW_LITERAL = eINSTANCE.getunknowLITERAL();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNKNOW_LITERAL__VALUE = eINSTANCE.getunknowLITERAL_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.ORImpl <em>OR</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.ORImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getOR()
     * @generated
     */
    EClass OR = eINSTANCE.getOR();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__LEFT = eINSTANCE.getOR_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__RIGHT = eINSTANCE.getOR_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.ANDImpl <em>AND</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.ANDImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getAND()
     * @generated
     */
    EClass AND = eINSTANCE.getAND();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND__LEFT = eINSTANCE.getAND_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND__RIGHT = eINSTANCE.getAND_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.EQUAL_DIFFImpl <em>EQUAL DIFF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.EQUAL_DIFFImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getEQUAL_DIFF()
     * @generated
     */
    EClass EQUAL_DIFF = eINSTANCE.getEQUAL_DIFF();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL_DIFF__LEFT = eINSTANCE.getEQUAL_DIFF_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUAL_DIFF__OP = eINSTANCE.getEQUAL_DIFF_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL_DIFF__RIGHT = eINSTANCE.getEQUAL_DIFF_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.COMPARISONImpl <em>COMPARISON</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.COMPARISONImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getCOMPARISON()
     * @generated
     */
    EClass COMPARISON = eINSTANCE.getCOMPARISON();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__LEFT = eINSTANCE.getCOMPARISON_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPARISON__OP = eINSTANCE.getCOMPARISON_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__RIGHT = eINSTANCE.getCOMPARISON_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.ADDImpl <em>ADD</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.ADDImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getADD()
     * @generated
     */
    EClass ADD = eINSTANCE.getADD();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__LEFT = eINSTANCE.getADD_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__RIGHT = eINSTANCE.getADD_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.SUBImpl <em>SUB</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.SUBImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getSUB()
     * @generated
     */
    EClass SUB = eINSTANCE.getSUB();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB__LEFT = eINSTANCE.getSUB_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB__RIGHT = eINSTANCE.getSUB_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.MULTImpl <em>MULT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.MULTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getMULT()
     * @generated
     */
    EClass MULT = eINSTANCE.getMULT();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT__LEFT = eINSTANCE.getMULT_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT__RIGHT = eINSTANCE.getMULT_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.DIVImpl <em>DIV</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.DIVImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getDIV()
     * @generated
     */
    EClass DIV = eINSTANCE.getDIV();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIV__LEFT = eINSTANCE.getDIV_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIV__RIGHT = eINSTANCE.getDIV_Right();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.NOTImpl <em>NOT</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.NOTImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getNOT()
     * @generated
     */
    EClass NOT = eINSTANCE.getNOT();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT__EXP = eINSTANCE.getNOT_Exp();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.intConstantImpl <em>int Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.intConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getintConstant()
     * @generated
     */
    EClass INT_CONSTANT = eINSTANCE.getintConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_CONSTANT__VALUE = eINSTANCE.getintConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.realConstantImpl <em>real Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.realConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getrealConstant()
     * @generated
     */
    EClass REAL_CONSTANT = eINSTANCE.getrealConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_CONSTANT__VALUE = eINSTANCE.getrealConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.strConstantImpl <em>str Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.strConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getstrConstant()
     * @generated
     */
    EClass STR_CONSTANT = eINSTANCE.getstrConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STR_CONSTANT__VALUE = eINSTANCE.getstrConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.enumConstantImpl <em>enum Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.enumConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getenumConstant()
     * @generated
     */
    EClass ENUM_CONSTANT = eINSTANCE.getenumConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_CONSTANT__VALUE = eINSTANCE.getenumConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.boolConstantImpl <em>bool Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.boolConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getboolConstant()
     * @generated
     */
    EClass BOOL_CONSTANT = eINSTANCE.getboolConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_CONSTANT__VALUE = eINSTANCE.getboolConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.bitConstantImpl <em>bit Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.bitConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getbitConstant()
     * @generated
     */
    EClass BIT_CONSTANT = eINSTANCE.getbitConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_CONSTANT__VALUE = eINSTANCE.getbitConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.hexConstantImpl <em>hex Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.hexConstantImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#gethexConstant()
     * @generated
     */
    EClass HEX_CONSTANT = eINSTANCE.gethexConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEX_CONSTANT__VALUE = eINSTANCE.gethexConstant_Value();

    /**
     * The meta object literal for the '{@link org.xtext.moduleDsl.impl.VarExpRefImpl <em>Var Exp Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.moduleDsl.impl.VarExpRefImpl
     * @see org.xtext.moduleDsl.impl.ModuleDslPackageImpl#getVarExpRef()
     * @generated
     */
    EClass VAR_EXP_REF = eINSTANCE.getVarExpRef();

    /**
     * The meta object literal for the '<em><b>Vref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_EXP_REF__VREF = eINSTANCE.getVarExpRef_Vref();

  }

} //ModuleDslPackage
