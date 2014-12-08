/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.LOOP_STATEMENT;
import org.xtext.moduleDsl.ModuleDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LOOP STATEMENT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.LOOP_STATEMENTImpl#getLoopCond <em>Loop Cond</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LOOP_STATEMENTImpl extends STATEMENTImpl implements LOOP_STATEMENT
{
  /**
   * The cached value of the '{@link #getLoopCond() <em>Loop Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoopCond()
   * @generated
   * @ordered
   */
  protected EXPRESSION loopCond;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LOOP_STATEMENTImpl()
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
    return ModuleDslPackage.Literals.LOOP_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EXPRESSION getLoopCond()
  {
    return loopCond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLoopCond(EXPRESSION newLoopCond, NotificationChain msgs)
  {
    EXPRESSION oldLoopCond = loopCond;
    loopCond = newLoopCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.LOOP_STATEMENT__LOOP_COND, oldLoopCond, newLoopCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLoopCond(EXPRESSION newLoopCond)
  {
    if (newLoopCond != loopCond)
    {
      NotificationChain msgs = null;
      if (loopCond != null)
        msgs = ((InternalEObject)loopCond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.LOOP_STATEMENT__LOOP_COND, null, msgs);
      if (newLoopCond != null)
        msgs = ((InternalEObject)newLoopCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.LOOP_STATEMENT__LOOP_COND, null, msgs);
      msgs = basicSetLoopCond(newLoopCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.LOOP_STATEMENT__LOOP_COND, newLoopCond, newLoopCond));
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
      case ModuleDslPackage.LOOP_STATEMENT__LOOP_COND:
        return basicSetLoopCond(null, msgs);
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
      case ModuleDslPackage.LOOP_STATEMENT__LOOP_COND:
        return getLoopCond();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ModuleDslPackage.LOOP_STATEMENT__LOOP_COND:
        setLoopCond((EXPRESSION)newValue);
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
      case ModuleDslPackage.LOOP_STATEMENT__LOOP_COND:
        setLoopCond((EXPRESSION)null);
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
      case ModuleDslPackage.LOOP_STATEMENT__LOOP_COND:
        return loopCond != null;
    }
    return super.eIsSet(featureID);
  }

} //LOOP_STATEMENTImpl
