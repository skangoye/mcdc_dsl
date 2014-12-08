/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VAR DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.VAR_DECL#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.VAR_DECL#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getVAR_DECL()
 * @model
 * @generated
 */
public interface VAR_DECL extends AbstractVAR_DECL
{
  /**
   * Returns the value of the '<em><b>Flow</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flow</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flow</em>' containment reference.
   * @see #setFlow(Flow)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getVAR_DECL_Flow()
   * @model containment="true"
   * @generated
   */
  Flow getFlow();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.VAR_DECL#getFlow <em>Flow</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flow</em>' containment reference.
   * @see #getFlow()
   * @generated
   */
  void setFlow(Flow value);

  /**
   * Returns the value of the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Range</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Range</em>' containment reference.
   * @see #setRange(RANGE)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getVAR_DECL_Range()
   * @model containment="true"
   * @generated
   */
  RANGE getRange();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.VAR_DECL#getRange <em>Range</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Range</em>' containment reference.
   * @see #getRange()
   * @generated
   */
  void setRange(RANGE value);

} // VAR_DECL
