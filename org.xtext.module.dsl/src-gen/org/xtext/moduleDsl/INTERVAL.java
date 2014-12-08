/**
 */
package org.xtext.moduleDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>INTERVAL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.INTERVAL#getLsqbr <em>Lsqbr</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.INTERVAL#getMin <em>Min</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.INTERVAL#getMax <em>Max</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.INTERVAL#getRsqbr <em>Rsqbr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERVAL()
 * @model
 * @generated
 */
public interface INTERVAL extends RANGE
{
  /**
   * Returns the value of the '<em><b>Lsqbr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lsqbr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lsqbr</em>' attribute.
   * @see #setLsqbr(String)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERVAL_Lsqbr()
   * @model
   * @generated
   */
  String getLsqbr();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.INTERVAL#getLsqbr <em>Lsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lsqbr</em>' attribute.
   * @see #getLsqbr()
   * @generated
   */
  void setLsqbr(String value);

  /**
   * Returns the value of the '<em><b>Min</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min</em>' containment reference.
   * @see #setMin(Literal)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERVAL_Min()
   * @model containment="true"
   * @generated
   */
  Literal getMin();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.INTERVAL#getMin <em>Min</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min</em>' containment reference.
   * @see #getMin()
   * @generated
   */
  void setMin(Literal value);

  /**
   * Returns the value of the '<em><b>Max</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max</em>' containment reference.
   * @see #setMax(Literal)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERVAL_Max()
   * @model containment="true"
   * @generated
   */
  Literal getMax();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.INTERVAL#getMax <em>Max</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max</em>' containment reference.
   * @see #getMax()
   * @generated
   */
  void setMax(Literal value);

  /**
   * Returns the value of the '<em><b>Rsqbr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rsqbr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rsqbr</em>' attribute.
   * @see #setRsqbr(String)
   * @see org.xtext.moduleDsl.ModuleDslPackage#getINTERVAL_Rsqbr()
   * @model
   * @generated
   */
  String getRsqbr();

  /**
   * Sets the value of the '{@link org.xtext.moduleDsl.INTERVAL#getRsqbr <em>Rsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rsqbr</em>' attribute.
   * @see #getRsqbr()
   * @generated
   */
  void setRsqbr(String value);

} // INTERVAL
