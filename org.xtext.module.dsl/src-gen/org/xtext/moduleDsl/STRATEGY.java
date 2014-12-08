/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STRATEGY</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.STRATEGY#getCritdecl <em>Critdecl</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.STRATEGY#getDataseldecl <em>Dataseldecl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getSTRATEGY()
 * @model
 * @generated
 */
public interface STRATEGY extends EObject
{
  /**
   * Returns the value of the '<em><b>Critdecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Critdecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Critdecl</em>' containment reference.
   * @see #setCritdecl(CRITERION_DECL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getSTRATEGY_Critdecl()
   * @model containment="true"
   * @generated
   */
  CRITERION_DECL getCritdecl();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.STRATEGY#getCritdecl <em>Critdecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Critdecl</em>' containment reference.
   * @see #getCritdecl()
   * @generated
   */
  void setCritdecl(CRITERION_DECL value);

  /**
   * Returns the value of the '<em><b>Dataseldecl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dataseldecl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dataseldecl</em>' containment reference.
   * @see #setDataseldecl(DATASEL_DECL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getSTRATEGY_Dataseldecl()
   * @model containment="true"
   * @generated
   */
  DATASEL_DECL getDataseldecl();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.STRATEGY#getDataseldecl <em>Dataseldecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dataseldecl</em>' containment reference.
   * @see #getDataseldecl()
   * @generated
   */
  void setDataseldecl(DATASEL_DECL value);

} // STRATEGY
