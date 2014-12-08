/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MODULE DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.MODULE_DECL#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.MODULE_DECL#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.MODULE_DECL#getInterface <em>Interface</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.MODULE_DECL#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getMODULE_DECL()
 * @model
 * @generated
 */
public interface MODULE_DECL extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getMODULE_DECL_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.MODULE_DECL#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Strategy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strategy</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Strategy</em>' containment reference.
   * @see #setStrategy(STRATEGY)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getMODULE_DECL_Strategy()
   * @model containment="true"
   * @generated
   */
  STRATEGY getStrategy();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.MODULE_DECL#getStrategy <em>Strategy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Strategy</em>' containment reference.
   * @see #getStrategy()
   * @generated
   */
  void setStrategy(STRATEGY value);

  /**
   * Returns the value of the '<em><b>Interface</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' containment reference.
   * @see #setInterface(INTERFACE)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getMODULE_DECL_Interface()
   * @model containment="true"
   * @generated
   */
  INTERFACE getInterface();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.MODULE_DECL#getInterface <em>Interface</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface</em>' containment reference.
   * @see #getInterface()
   * @generated
   */
  void setInterface(INTERFACE value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(BODY)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getMODULE_DECL_Body()
   * @model containment="true"
   * @generated
   */
  BODY getBody();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.MODULE_DECL#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(BODY value);

} // MODULE_DECL
