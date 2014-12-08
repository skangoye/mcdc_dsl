/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CST DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.CST_DECL#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.CST_DECL#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getCST_DECL()
 * @model
 * @generated
 */
public interface CST_DECL extends AbstractVAR_DECL
{
  /**
   * Returns the value of the '<em><b>Flow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flow</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flow</em>' attribute.
   * @see #setFlow(String)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getCST_DECL_Flow()
   * @model
   * @generated
   */
  String getFlow();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.CST_DECL#getFlow <em>Flow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flow</em>' attribute.
   * @see #getFlow()
   * @generated
   */
  void setFlow(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Literal)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getCST_DECL_Value()
   * @model containment="true"
   * @generated
   */
  Literal getValue();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.CST_DECL#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Literal value);

} // CST_DECL
