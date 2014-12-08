/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CRITERION DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.CRITERION_DECL#getCrit <em>Crit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getCRITERION_DECL()
 * @model
 * @generated
 */
public interface CRITERION_DECL extends EObject
{
  /**
   * Returns the value of the '<em><b>Crit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Crit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Crit</em>' containment reference.
   * @see #setCrit(CRITERION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getCRITERION_DECL_Crit()
   * @model containment="true"
   * @generated
   */
  CRITERION getCrit();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.CRITERION_DECL#getCrit <em>Crit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Crit</em>' containment reference.
   * @see #getCrit()
   * @generated
   */
  void setCrit(CRITERION value);

} // CRITERION_DECL
