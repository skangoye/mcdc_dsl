/**
 */
package org.xtext.moduleDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.IF_STATEMENT;
import org.xtext.moduleDsl.ModuleDslPackage;
import org.xtext.moduleDsl.STATEMENT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IF STATEMENT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.IF_STATEMENTImpl#getIfCond <em>If Cond</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.IF_STATEMENTImpl#getIfst <em>Ifst</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.IF_STATEMENTImpl#getElst <em>Elst</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IF_STATEMENTImpl extends STATEMENTImpl implements IF_STATEMENT
{
  /**
   * The cached value of the '{@link #getIfCond() <em>If Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfCond()
   * @generated
   * @ordered
   */
  protected EXPRESSION ifCond;

  /**
   * The cached value of the '{@link #getIfst() <em>Ifst</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfst()
   * @generated
   * @ordered
   */
  protected EList<STATEMENT> ifst;

  /**
   * The cached value of the '{@link #getElst() <em>Elst</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElst()
   * @generated
   * @ordered
   */
  protected EList<STATEMENT> elst;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IF_STATEMENTImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ModuleDslPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EXPRESSION getIfCond()
  {
    return ifCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfCond(EXPRESSION newIfCond, NotificationChain msgs)
  {
    EXPRESSION oldIfCond = ifCond;
    ifCond = newIfCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.IF_STATEMENT__IF_COND, oldIfCond, newIfCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfCond(EXPRESSION newIfCond)
  {
    if (newIfCond != ifCond)
    {
      NotificationChain msgs = null;
      if (ifCond != null)
        msgs = ((InternalEObject)ifCond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.IF_STATEMENT__IF_COND, null, msgs);
      if (newIfCond != null)
        msgs = ((InternalEObject)newIfCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.IF_STATEMENT__IF_COND, null, msgs);
      msgs = basicSetIfCond(newIfCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.IF_STATEMENT__IF_COND, newIfCond, newIfCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<STATEMENT> getIfst()
  {
    if (ifst == null)
    {
      ifst = new EObjectContainmentEList<STATEMENT>(STATEMENT.class, this, ModuleDslPackage.IF_STATEMENT__IFST);
    }
    return ifst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<STATEMENT> getElst()
  {
    if (elst == null)
    {
      elst = new EObjectContainmentEList<STATEMENT>(STATEMENT.class, this, ModuleDslPackage.IF_STATEMENT__ELST);
    }
    return elst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ModuleDslPackage.IF_STATEMENT__IF_COND:
        return basicSetIfCond(null, msgs);
      case ModuleDslPackage.IF_STATEMENT__IFST:
        return ((InternalEList<?>)getIfst()).basicRemove(otherEnd, msgs);
      case ModuleDslPackage.IF_STATEMENT__ELST:
        return ((InternalEList<?>)getElst()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ModuleDslPackage.IF_STATEMENT__IF_COND:
        return getIfCond();
      case ModuleDslPackage.IF_STATEMENT__IFST:
        return getIfst();
      case ModuleDslPackage.IF_STATEMENT__ELST:
        return getElst();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ModuleDslPackage.IF_STATEMENT__IF_COND:
        setIfCond((EXPRESSION)newValue);
        return;
      case ModuleDslPackage.IF_STATEMENT__IFST:
        getIfst().clear();
        getIfst().addAll((Collection<? extends STATEMENT>)newValue);
        return;
      case ModuleDslPackage.IF_STATEMENT__ELST:
        getElst().clear();
        getElst().addAll((Collection<? extends STATEMENT>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ModuleDslPackage.IF_STATEMENT__IF_COND:
        setIfCond((EXPRESSION)null);
        return;
      case ModuleDslPackage.IF_STATEMENT__IFST:
        getIfst().clear();
        return;
      case ModuleDslPackage.IF_STATEMENT__ELST:
        getElst().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ModuleDslPackage.IF_STATEMENT__IF_COND:
        return ifCond != null;
      case ModuleDslPackage.IF_STATEMENT__IFST:
        return ifst != null && !ifst.isEmpty();
      case ModuleDslPackage.IF_STATEMENT__ELST:
        return elst != null && !elst.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IF_STATEMENTImpl
