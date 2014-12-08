/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LANGUAGE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.LANGUAGE#getModules <em>Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getLANGUAGE()
 * @model
 * @generated
 */
public interface LANGUAGE extends EObject
{
  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.moduleDsl.MODULE_DECL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference list.
   * @see org.xtext.moduleDsl.ModuleDslPackage#getLANGUAGE_Modules()
   * @model containment="true"
   * @generated
   */
  EList<MODULE_DECL> getModules();

} // LANGUAGE
