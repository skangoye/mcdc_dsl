/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xtext.moduleDsl.ModuleDslPackage
 * @generated
 */
public interface ModuleDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModuleDslFactory eINSTANCE = org.xtext.moduleDsl.impl.ModuleDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>LANGUAGE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LANGUAGE</em>'.
   * @generated
   */
  LANGUAGE createLANGUAGE();

  /**
   * Returns a new object of class '<em>MODULE DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MODULE DECL</em>'.
   * @generated
   */
  MODULE_DECL createMODULE_DECL();

  /**
   * Returns a new object of class '<em>STRATEGY</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>STRATEGY</em>'.
   * @generated
   */
  STRATEGY createSTRATEGY();

  /**
   * Returns a new object of class '<em>INTERFACE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>INTERFACE</em>'.
   * @generated
   */
  INTERFACE createINTERFACE();

  /**
   * Returns a new object of class '<em>BODY</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>BODY</em>'.
   * @generated
   */
  BODY createBODY();

  /**
   * Returns a new object of class '<em>CRITERION DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CRITERION DECL</em>'.
   * @generated
   */
  CRITERION_DECL createCRITERION_DECL();

  /**
   * Returns a new object of class '<em>DATASEL DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DATASEL DECL</em>'.
   * @generated
   */
  DATASEL_DECL createDATASEL_DECL();

  /**
   * Returns a new object of class '<em>CRITERION</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CRITERION</em>'.
   * @generated
   */
  CRITERION createCRITERION();

  /**
   * Returns a new object of class '<em>DATASEL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DATASEL</em>'.
   * @generated
   */
  DATASEL createDATASEL();

  /**
   * Returns a new object of class '<em>Abstract VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract VAR DECL</em>'.
   * @generated
   */
  AbstractVAR_DECL createAbstractVAR_DECL();

  /**
   * Returns a new object of class '<em>VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>VAR DECL</em>'.
   * @generated
   */
  VAR_DECL createVAR_DECL();

  /**
   * Returns a new object of class '<em>Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Flow</em>'.
   * @generated
   */
  Flow createFlow();

  /**
   * Returns a new object of class '<em>CST DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>CST DECL</em>'.
   * @generated
   */
  CST_DECL createCST_DECL();

  /**
   * Returns a new object of class '<em>Tmp VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tmp VAR DECL</em>'.
   * @generated
   */
  TmpVAR_DECL createTmpVAR_DECL();

  /**
   * Returns a new object of class '<em>TYPE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TYPE</em>'.
   * @generated
   */
  TYPE createTYPE();

  /**
   * Returns a new object of class '<em>RANGE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RANGE</em>'.
   * @generated
   */
  RANGE createRANGE();

  /**
   * Returns a new object of class '<em>INTERVAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>INTERVAL</em>'.
   * @generated
   */
  INTERVAL createINTERVAL();

  /**
   * Returns a new object of class '<em>LSET</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LSET</em>'.
   * @generated
   */
  LSET createLSET();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>STATEMENT</em>'.
   * @generated
   */
  STATEMENT createSTATEMENT();

  /**
   * Returns a new object of class '<em>IF STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IF STATEMENT</em>'.
   * @generated
   */
  IF_STATEMENT createIF_STATEMENT();

  /**
   * Returns a new object of class '<em>LOOP STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LOOP STATEMENT</em>'.
   * @generated
   */
  LOOP_STATEMENT createLOOP_STATEMENT();

  /**
   * Returns a new object of class '<em>ERROR STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ERROR STATEMENT</em>'.
   * @generated
   */
  ERROR_STATEMENT createERROR_STATEMENT();

  /**
   * Returns a new object of class '<em>ASSIGN STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASSIGN STATEMENT</em>'.
   * @generated
   */
  ASSIGN_STATEMENT createASSIGN_STATEMENT();

  /**
   * Returns a new object of class '<em>VAR REF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>VAR REF</em>'.
   * @generated
   */
  VAR_REF createVAR_REF();

  /**
   * Returns a new object of class '<em>EXPRESSION</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EXPRESSION</em>'.
   * @generated
   */
  EXPRESSION createEXPRESSION();

  /**
   * Returns a new object of class '<em>int LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>int LITERAL</em>'.
   * @generated
   */
  intLITERAL createintLITERAL();

  /**
   * Returns a new object of class '<em>real LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>real LITERAL</em>'.
   * @generated
   */
  realLITERAL createrealLITERAL();

  /**
   * Returns a new object of class '<em>bool LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>bool LITERAL</em>'.
   * @generated
   */
  boolLITERAL createboolLITERAL();

  /**
   * Returns a new object of class '<em>str LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>str LITERAL</em>'.
   * @generated
   */
  strLITERAL createstrLITERAL();

  /**
   * Returns a new object of class '<em>enum LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>enum LITERAL</em>'.
   * @generated
   */
  enumLITERAL createenumLITERAL();

  /**
   * Returns a new object of class '<em>bit LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>bit LITERAL</em>'.
   * @generated
   */
  bitLITERAL createbitLITERAL();

  /**
   * Returns a new object of class '<em>hex LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>hex LITERAL</em>'.
   * @generated
   */
  hexLITERAL createhexLITERAL();

  /**
   * Returns a new object of class '<em>unknow LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>unknow LITERAL</em>'.
   * @generated
   */
  unknowLITERAL createunknowLITERAL();

  /**
   * Returns a new object of class '<em>OR</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>OR</em>'.
   * @generated
   */
  OR createOR();

  /**
   * Returns a new object of class '<em>AND</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AND</em>'.
   * @generated
   */
  AND createAND();

  /**
   * Returns a new object of class '<em>EQUAL DIFF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EQUAL DIFF</em>'.
   * @generated
   */
  EQUAL_DIFF createEQUAL_DIFF();

  /**
   * Returns a new object of class '<em>COMPARISON</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>COMPARISON</em>'.
   * @generated
   */
  COMPARISON createCOMPARISON();

  /**
   * Returns a new object of class '<em>ADD</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ADD</em>'.
   * @generated
   */
  ADD createADD();

  /**
   * Returns a new object of class '<em>SUB</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SUB</em>'.
   * @generated
   */
  SUB createSUB();

  /**
   * Returns a new object of class '<em>MULT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MULT</em>'.
   * @generated
   */
  MULT createMULT();

  /**
   * Returns a new object of class '<em>DIV</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DIV</em>'.
   * @generated
   */
  DIV createDIV();

  /**
   * Returns a new object of class '<em>NOT</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NOT</em>'.
   * @generated
   */
  NOT createNOT();

  /**
   * Returns a new object of class '<em>int Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>int Constant</em>'.
   * @generated
   */
  intConstant createintConstant();

  /**
   * Returns a new object of class '<em>real Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>real Constant</em>'.
   * @generated
   */
  realConstant createrealConstant();

  /**
   * Returns a new object of class '<em>str Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>str Constant</em>'.
   * @generated
   */
  strConstant createstrConstant();

  /**
   * Returns a new object of class '<em>enum Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>enum Constant</em>'.
   * @generated
   */
  enumConstant createenumConstant();

  /**
   * Returns a new object of class '<em>bool Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>bool Constant</em>'.
   * @generated
   */
  boolConstant createboolConstant();

  /**
   * Returns a new object of class '<em>bit Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>bit Constant</em>'.
   * @generated
   */
  bitConstant createbitConstant();

  /**
   * Returns a new object of class '<em>hex Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>hex Constant</em>'.
   * @generated
   */
  hexConstant createhexConstant();

  /**
   * Returns a new object of class '<em>Var Exp Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Exp Ref</em>'.
   * @generated
   */
  VarExpRef createVarExpRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ModuleDslPackage getModuleDslPackage();

} //ModuleDslFactory
