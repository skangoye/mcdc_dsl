/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmp VAR DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.TmpVAR_DECL#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getTmpVAR_DECL()
 * @model
 * @generated
 */
public interface TmpVAR_DECL extends AbstractVAR_DECL
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(EXPRESSION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getTmpVAR_DECL_Value()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getValue();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.TmpVAR_DECL#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(EXPRESSION value);

} // TmpVAR_DECL
