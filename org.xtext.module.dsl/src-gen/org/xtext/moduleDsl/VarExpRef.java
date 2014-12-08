/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Exp Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.VarExpRef#getVref <em>Vref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getVarExpRef()
 * @model
 * @generated
 */
public interface VarExpRef extends EXPRESSION
{
  /**
   * Returns the value of the '<em><b>Vref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vref</em>' reference.
   * @see #setVref(AbstractVAR_DECL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getVarExpRef_Vref()
   * @model
   * @generated
   */
  AbstractVAR_DECL getVref();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.VarExpRef#getVref <em>Vref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vref</em>' reference.
   * @see #getVref()
   * @generated
   */
  void setVref(AbstractVAR_DECL value);

} // VarExpRef
