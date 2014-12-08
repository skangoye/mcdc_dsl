/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VAR REF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.VAR_REF#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getVAR_REF()
 * @model
 * @generated
 */
public interface VAR_REF extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(AbstractVAR_DECL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getVAR_REF_Variable()
   * @model
   * @generated
   */
  AbstractVAR_DECL getVariable();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.VAR_REF#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(AbstractVAR_DECL value);

} // VAR_REF
