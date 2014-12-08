/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SUB</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.SUB#getLeft <em>Left</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.SUB#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getSUB()
 * @model
 * @generated
 */
public interface SUB extends EXPRESSION
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
   * @see #setLeft(EXPRESSION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getSUB_Left()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getLeft();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.SUB#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(EXPRESSION value);

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
   * @see org.xtext.moduleDsl.ModuleDslPackage#getSUB_Right()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getRight();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.SUB#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(EXPRESSION value);

} // SUB
