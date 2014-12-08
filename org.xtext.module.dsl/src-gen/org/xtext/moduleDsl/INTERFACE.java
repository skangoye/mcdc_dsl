/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>INTERFACE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.INTERFACE#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERFACE()
 * @model
 * @generated
 */
public interface INTERFACE extends EObject
{
  /**
   * Returns the value of the '<em><b>Declaration</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.moduleDsl.AbstractVAR_DECL}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' containment reference list.
   * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERFACE_Declaration()
   * @model containment="true"
   * @generated
   */
  EList<AbstractVAR_DECL> getDeclaration();

} // INTERFACE
