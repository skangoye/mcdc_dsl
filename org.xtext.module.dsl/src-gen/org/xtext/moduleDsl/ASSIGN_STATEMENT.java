/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASSIGN STATEMENT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getLeft <em>Left</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getASSIGN_STATEMENT()
 * @model
 * @generated
 */
public interface ASSIGN_STATEMENT extends STATEMENT
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(VAR_REF)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getASSIGN_STATEMENT_Left()
   * @model containment="true"
   * @generated
   */
  VAR_REF getLeft();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(VAR_REF value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(EXPRESSION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getASSIGN_STATEMENT_Right()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getRight();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.ASSIGN_STATEMENT#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(EXPRESSION value);

} // ASSIGN_STATEMENT
