/**
 */
package org.xtext.moduleDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.moduleDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.moduleDsl.ModuleDslPackage
 * @generated
 */
public class ModuleDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ModuleDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ModuleDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ModuleDslPackage.LANGUAGE:
      {
        LANGUAGE language = (LANGUAGE)theEObject;
        T result = caseLANGUAGE(language);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.MODULE_DECL:
      {
        MODULE_DECL modulE_DECL = (MODULE_DECL)theEObject;
        T result = caseMODULE_DECL(modulE_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.STRATEGY:
      {
        STRATEGY strategy = (STRATEGY)theEObject;
        T result = caseSTRATEGY(strategy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.INTERFACE:
      {
        INTERFACE interface_ = (INTERFACE)theEObject;
        T result = caseINTERFACE(interface_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.BODY:
      {
        BODY body = (BODY)theEObject;
        T result = caseBODY(body);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.CRITERION_DECL:
      {
        CRITERION_DECL criterioN_DECL = (CRITERION_DECL)theEObject;
        T result = caseCRITERION_DECL(criterioN_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.DATASEL_DECL:
      {
        DATASEL_DECL dataseL_DECL = (DATASEL_DECL)theEObject;
        T result = caseDATASEL_DECL(dataseL_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.CRITERION:
      {
        CRITERION criterion = (CRITERION)theEObject;
        T result = caseCRITERION(criterion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.DATASEL:
      {
        DATASEL datasel = (DATASEL)theEObject;
        T result = caseDATASEL(datasel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ABSTRACT_VAR_DECL:
      {
        AbstractVAR_DECL abstractVAR_DECL = (AbstractVAR_DECL)theEObject;
        T result = caseAbstractVAR_DECL(abstractVAR_DECL);
        if (result == null) result = caseSTATEMENT(abstractVAR_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.VAR_DECL:
      {
        VAR_DECL vaR_DECL = (VAR_DECL)theEObject;
        T result = caseVAR_DECL(vaR_DECL);
        if (result == null) result = caseAbstractVAR_DECL(vaR_DECL);
        if (result == null) result = caseSTATEMENT(vaR_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.FLOW:
      {
        Flow flow = (Flow)theEObject;
        T result = caseFlow(flow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.CST_DECL:
      {
        CST_DECL csT_DECL = (CST_DECL)theEObject;
        T result = caseCST_DECL(csT_DECL);
        if (result == null) result = caseAbstractVAR_DECL(csT_DECL);
        if (result == null) result = caseSTATEMENT(csT_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.TMP_VAR_DECL:
      {
        TmpVAR_DECL tmpVAR_DECL = (TmpVAR_DECL)theEObject;
        T result = caseTmpVAR_DECL(tmpVAR_DECL);
        if (result == null) result = caseAbstractVAR_DECL(tmpVAR_DECL);
        if (result == null) result = caseSTATEMENT(tmpVAR_DECL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.TYPE:
      {
        TYPE type = (TYPE)theEObject;
        T result = caseTYPE(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.RANGE:
      {
        RANGE range = (RANGE)theEObject;
        T result = caseRANGE(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.INTERVAL:
      {
        INTERVAL interval = (INTERVAL)theEObject;
        T result = caseINTERVAL(interval);
        if (result == null) result = caseRANGE(interval);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.LSET:
      {
        LSET lset = (LSET)theEObject;
        T result = caseLSET(lset);
        if (result == null) result = caseRANGE(lset);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.STATEMENT:
      {
        STATEMENT statement = (STATEMENT)theEObject;
        T result = caseSTATEMENT(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.IF_STATEMENT:
      {
        IF_STATEMENT iF_STATEMENT = (IF_STATEMENT)theEObject;
        T result = caseIF_STATEMENT(iF_STATEMENT);
        if (result == null) result = caseSTATEMENT(iF_STATEMENT);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.LOOP_STATEMENT:
      {
        LOOP_STATEMENT looP_STATEMENT = (LOOP_STATEMENT)theEObject;
        T result = caseLOOP_STATEMENT(looP_STATEMENT);
        if (result == null) result = caseSTATEMENT(looP_STATEMENT);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ERROR_STATEMENT:
      {
        ERROR_STATEMENT erroR_STATEMENT = (ERROR_STATEMENT)theEObject;
        T result = caseERROR_STATEMENT(erroR_STATEMENT);
        if (result == null) result = caseSTATEMENT(erroR_STATEMENT);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ASSIGN_STATEMENT:
      {
        ASSIGN_STATEMENT assigN_STATEMENT = (ASSIGN_STATEMENT)theEObject;
        T result = caseASSIGN_STATEMENT(assigN_STATEMENT);
        if (result == null) result = caseSTATEMENT(assigN_STATEMENT);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.VAR_REF:
      {
        VAR_REF vaR_REF = (VAR_REF)theEObject;
        T result = caseVAR_REF(vaR_REF);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.EXPRESSION:
      {
        EXPRESSION expression = (EXPRESSION)theEObject;
        T result = caseEXPRESSION(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.INT_LITERAL:
      {
        intLITERAL intLITERAL = (intLITERAL)theEObject;
        T result = caseintLITERAL(intLITERAL);
        if (result == null) result = caseLiteral(intLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.REAL_LITERAL:
      {
        realLITERAL realLITERAL = (realLITERAL)theEObject;
        T result = caserealLITERAL(realLITERAL);
        if (result == null) result = caseLiteral(realLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.BOOL_LITERAL:
      {
        boolLITERAL boolLITERAL = (boolLITERAL)theEObject;
        T result = caseboolLITERAL(boolLITERAL);
        if (result == null) result = caseLiteral(boolLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.STR_LITERAL:
      {
        strLITERAL strLITERAL = (strLITERAL)theEObject;
        T result = casestrLITERAL(strLITERAL);
        if (result == null) result = caseLiteral(strLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ENUM_LITERAL:
      {
        enumLITERAL enumLITERAL = (enumLITERAL)theEObject;
        T result = caseenumLITERAL(enumLITERAL);
        if (result == null) result = caseLiteral(enumLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.BIT_LITERAL:
      {
        bitLITERAL bitLITERAL = (bitLITERAL)theEObject;
        T result = casebitLITERAL(bitLITERAL);
        if (result == null) result = caseLiteral(bitLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.HEX_LITERAL:
      {
        hexLITERAL hexLITERAL = (hexLITERAL)theEObject;
        T result = casehexLITERAL(hexLITERAL);
        if (result == null) result = caseLiteral(hexLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.UNKNOW_LITERAL:
      {
        unknowLITERAL unknowLITERAL = (unknowLITERAL)theEObject;
        T result = caseunknowLITERAL(unknowLITERAL);
        if (result == null) result = caseLiteral(unknowLITERAL);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.OR:
      {
        OR or = (OR)theEObject;
        T result = caseOR(or);
        if (result == null) result = caseEXPRESSION(or);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.AND:
      {
        AND and = (AND)theEObject;
        T result = caseAND(and);
        if (result == null) result = caseEXPRESSION(and);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.EQUAL_DIFF:
      {
        EQUAL_DIFF equaL_DIFF = (EQUAL_DIFF)theEObject;
        T result = caseEQUAL_DIFF(equaL_DIFF);
        if (result == null) result = caseEXPRESSION(equaL_DIFF);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.COMPARISON:
      {
        COMPARISON comparison = (COMPARISON)theEObject;
        T result = caseCOMPARISON(comparison);
        if (result == null) result = caseEXPRESSION(comparison);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ADD:
      {
        ADD add = (ADD)theEObject;
        T result = caseADD(add);
        if (result == null) result = caseEXPRESSION(add);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.SUB:
      {
        SUB sub = (SUB)theEObject;
        T result = caseSUB(sub);
        if (result == null) result = caseEXPRESSION(sub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.MULT:
      {
        MULT mult = (MULT)theEObject;
        T result = caseMULT(mult);
        if (result == null) result = caseEXPRESSION(mult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.DIV:
      {
        DIV div = (DIV)theEObject;
        T result = caseDIV(div);
        if (result == null) result = caseEXPRESSION(div);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.NOT:
      {
        NOT not = (NOT)theEObject;
        T result = caseNOT(not);
        if (result == null) result = caseEXPRESSION(not);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.INT_CONSTANT:
      {
        intConstant intConstant = (intConstant)theEObject;
        T result = caseintConstant(intConstant);
        if (result == null) result = caseEXPRESSION(intConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.REAL_CONSTANT:
      {
        realConstant realConstant = (realConstant)theEObject;
        T result = caserealConstant(realConstant);
        if (result == null) result = caseEXPRESSION(realConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.STR_CONSTANT:
      {
        strConstant strConstant = (strConstant)theEObject;
        T result = casestrConstant(strConstant);
        if (result == null) result = caseEXPRESSION(strConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.ENUM_CONSTANT:
      {
        enumConstant enumConstant = (enumConstant)theEObject;
        T result = caseenumConstant(enumConstant);
        if (result == null) result = caseEXPRESSION(enumConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.BOOL_CONSTANT:
      {
        boolConstant boolConstant = (boolConstant)theEObject;
        T result = caseboolConstant(boolConstant);
        if (result == null) result = caseEXPRESSION(boolConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.BIT_CONSTANT:
      {
        bitConstant bitConstant = (bitConstant)theEObject;
        T result = casebitConstant(bitConstant);
        if (result == null) result = caseEXPRESSION(bitConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.HEX_CONSTANT:
      {
        hexConstant hexConstant = (hexConstant)theEObject;
        T result = casehexConstant(hexConstant);
        if (result == null) result = caseEXPRESSION(hexConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModuleDslPackage.VAR_EXP_REF:
      {
        VarExpRef varExpRef = (VarExpRef)theEObject;
        T result = caseVarExpRef(varExpRef);
        if (result == null) result = caseEXPRESSION(varExpRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LANGUAGE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LANGUAGE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLANGUAGE(LANGUAGE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MODULE DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MODULE DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMODULE_DECL(MODULE_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>STRATEGY</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>STRATEGY</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTRATEGY(STRATEGY object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INTERFACE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INTERFACE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINTERFACE(INTERFACE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BODY</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BODY</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBODY(BODY object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CRITERION DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CRITERION DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCRITERION_DECL(CRITERION_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>DATASEL DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DATASEL DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDATASEL_DECL(DATASEL_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CRITERION</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CRITERION</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCRITERION(CRITERION object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>DATASEL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DATASEL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDATASEL(DATASEL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract VAR DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractVAR_DECL(AbstractVAR_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>VAR DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVAR_DECL(VAR_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFlow(Flow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CST DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CST DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCST_DECL(CST_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tmp VAR DECL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tmp VAR DECL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTmpVAR_DECL(TmpVAR_DECL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TYPE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TYPE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTYPE(TYPE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RANGE</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RANGE</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRANGE(RANGE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INTERVAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INTERVAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINTERVAL(INTERVAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LSET</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LSET</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLSET(LSET object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>STATEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTATEMENT(STATEMENT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IF STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IF STATEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIF_STATEMENT(IF_STATEMENT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LOOP STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LOOP STATEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLOOP_STATEMENT(LOOP_STATEMENT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ERROR STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ERROR STATEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseERROR_STATEMENT(ERROR_STATEMENT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASSIGN STATEMENT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASSIGN STATEMENT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASSIGN_STATEMENT(ASSIGN_STATEMENT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>VAR REF</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>VAR REF</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVAR_REF(VAR_REF object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EXPRESSION</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EXPRESSION</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEXPRESSION(EXPRESSION object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>int LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>int LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseintLITERAL(intLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>real LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>real LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserealLITERAL(realLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>bool LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>bool LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseboolLITERAL(boolLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>str LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>str LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casestrLITERAL(strLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>enum LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>enum LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseenumLITERAL(enumLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>bit LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>bit LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casebitLITERAL(bitLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>hex LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>hex LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casehexLITERAL(hexLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>unknow LITERAL</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>unknow LITERAL</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseunknowLITERAL(unknowLITERAL object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>OR</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOR(OR object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AND</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AND</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAND(AND object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EQUAL DIFF</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EQUAL DIFF</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEQUAL_DIFF(EQUAL_DIFF object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>COMPARISON</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>COMPARISON</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCOMPARISON(COMPARISON object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ADD</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ADD</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseADD(ADD object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SUB</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SUB</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSUB(SUB object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MULT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MULT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMULT(MULT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>DIV</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DIV</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDIV(DIV object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NOT</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NOT</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNOT(NOT object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>int Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>int Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseintConstant(intConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>real Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>real Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserealConstant(realConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>str Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>str Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casestrConstant(strConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>enum Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>enum Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseenumConstant(enumConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>bool Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>bool Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseboolConstant(boolConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>bit Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>bit Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casebitConstant(bitConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>hex Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>hex Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casehexConstant(hexConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Exp Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Exp Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarExpRef(VarExpRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ModuleDslSwitch
