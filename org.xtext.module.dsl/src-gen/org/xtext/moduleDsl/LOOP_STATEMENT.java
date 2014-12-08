/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LOOP STATEMENT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.LOOP_STATEMENT#getLoopCond <em>Loop Cond</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getLOOP_STATEMENT()
 * @model
 * @generated
 */
public interface LOOP_STATEMENT extends STATEMENT
{
  /**
   * Returns the value of the '<em><b>Loop Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Loop Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop Cond</em>' containment reference.
   * @see #setLoopCond(EXPRESSION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getLOOP_STATEMENT_LoopCond()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getLoopCond();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.LOOP_STATEMENT#getLoopCond <em>Loop Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop Cond</em>' containment reference.
   * @see #getLoopCond()
   * @generated
   */
  void setLoopCond(EXPRESSION value);

} // LOOP_STATEMENT
