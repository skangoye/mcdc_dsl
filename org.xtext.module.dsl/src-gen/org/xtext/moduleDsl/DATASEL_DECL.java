/**
 */
package org.xtext.moduleDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DATASEL DECL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.DATASEL_DECL#getData1 <em>Data1</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.DATASEL_DECL#getData2 <em>Data2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getDATASEL_DECL()
 * @model
 * @generated
 */
public interface DATASEL_DECL extends EObject
{
  /**
   * Returns the value of the '<em><b>Data1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data1</em>' containment reference.
   * @see #setData1(DATASEL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getDATASEL_DECL_Data1()
   * @model containment="true"
   * @generated
   */
  DATASEL getData1();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.DATASEL_DECL#getData1 <em>Data1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data1</em>' containment reference.
   * @see #getData1()
   * @generated
   */
  void setData1(DATASEL value);

  /**
   * Returns the value of the '<em><b>Data2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data2</em>' containment reference.
   * @see #setData2(DATASEL)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getDATASEL_DECL_Data2()
   * @model containment="true"
   * @generated
   */
  DATASEL getData2();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.DATASEL_DECL#getData2 <em>Data2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data2</em>' containment reference.
   * @see #getData2()
   * @generated
   */
  void setData2(DATASEL value);

} // DATASEL_DECL
