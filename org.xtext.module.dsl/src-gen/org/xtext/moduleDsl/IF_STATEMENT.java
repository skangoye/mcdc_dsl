/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IF STATEMENT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.IF_STATEMENT#getIfCond <em>If Cond</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.IF_STATEMENT#getIfst <em>Ifst</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.IF_STATEMENT#getElst <em>Elst</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getIF_STATEMENT()
 * @model
 * @generated
 */
public interface IF_STATEMENT extends STATEMENT
{
  /**
   * Returns the value of the '<em><b>If Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Cond</em>' containment reference.
   * @see #setIfCond(EXPRESSION)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getIF_STATEMENT_IfCond()
   * @model containment="true"
   * @generated
   */
  EXPRESSION getIfCond();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.IF_STATEMENT#getIfCond <em>If Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Cond</em>' containment reference.
   * @see #getIfCond()
   * @generated
   */
  void setIfCond(EXPRESSION value);

  /**
   * Returns the value of the '<em><b>Ifst</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.moduleDsl.STATEMENT}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ifst</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ifst</em>' containment reference list.
   * @see org.xtext.moduleDsl.ModuleDslPackage#getIF_STATEMENT_Ifst()
   * @model containment="true"
   * @generated
   */
  EList<STATEMENT> getIfst();

  /**
   * Returns the value of the '<em><b>Elst</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.moduleDsl.STATEMENT}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elst</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elst</em>' containment reference list.
   * @see org.xtext.moduleDsl.ModuleDslPackage#getIF_STATEMENT_Elst()
   * @model containment="true"
   * @generated
   */
  EList<STATEMENT> getElst();

} // IF_STATEMENT
