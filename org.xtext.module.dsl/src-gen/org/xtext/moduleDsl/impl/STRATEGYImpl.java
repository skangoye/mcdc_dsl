/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.moduleDsl.CRITERION_DECL;
import org.xtext.moduleDsl.DATASEL_DECL;
import org.xtext.moduleDsl.ModuleDslPackage;
import org.xtext.moduleDsl.STRATEGY;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STRATEGY</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.STRATEGYImpl#getCritdecl <em>Critdecl</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.STRATEGYImpl#getDataseldecl <em>Dataseldecl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STRATEGYImpl extends MinimalEObjectImpl.Container implements STRATEGY
{
  /**
   * The cached value of the '{@link #getCritdecl() <em>Critdecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCritdecl()
   * @generated
   * @ordered
   */
  protected CRITERION_DECL critdecl;

  /**
   * The cached value of the '{@link #getDataseldecl() <em>Dataseldecl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataseldecl()
   * @generated
   * @ordered
   */
  protected DATASEL_DECL dataseldecl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected STRATEGYImpl()
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
    return ModuleDslPackage.Literals.STRATEGY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CRITERION_DECL getCritdecl()
  {
    return critdecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCritdecl(CRITERION_DECL newCritdecl, NotificationChain msgs)
  {
    CRITERION_DECL oldCritdecl = critdecl;
    critdecl = newCritdecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.STRATEGY__CRITDECL, oldCritdecl, newCritdecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCritdecl(CRITERION_DECL newCritdecl)
  {
    if (newCritdecl != critdecl)
    {
      NotificationChain msgs = null;
      if (critdecl != null)
        msgs = ((InternalEObject)critdecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.STRATEGY__CRITDECL, null, msgs);
      if (newCritdecl != null)
        msgs = ((InternalEObject)newCritdecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.STRATEGY__CRITDECL, null, msgs);
      msgs = basicSetCritdecl(newCritdecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.STRATEGY__CRITDECL, newCritdecl, newCritdecl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DATASEL_DECL getDataseldecl()
  {
    return dataseldecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDataseldecl(DATASEL_DECL newDataseldecl, NotificationChain msgs)
  {
    DATASEL_DECL oldDataseldecl = dataseldecl;
    dataseldecl = newDataseldecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.STRATEGY__DATASELDECL, oldDataseldecl, newDataseldecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataseldecl(DATASEL_DECL newDataseldecl)
  {
    if (newDataseldecl != dataseldecl)
    {
      NotificationChain msgs = null;
      if (dataseldecl != null)
        msgs = ((InternalEObject)dataseldecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.STRATEGY__DATASELDECL, null, msgs);
      if (newDataseldecl != null)
        msgs = ((InternalEObject)newDataseldecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.STRATEGY__DATASELDECL, null, msgs);
      msgs = basicSetDataseldecl(newDataseldecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.STRATEGY__DATASELDECL, newDataseldecl, newDataseldecl));
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
      case ModuleDslPackage.STRATEGY__CRITDECL:
        return basicSetCritdecl(null, msgs);
      case ModuleDslPackage.STRATEGY__DATASELDECL:
        return basicSetDataseldecl(null, msgs);
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
      case ModuleDslPackage.STRATEGY__CRITDECL:
        return getCritdecl();
      case ModuleDslPackage.STRATEGY__DATASELDECL:
        return getDataseldecl();
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
      case ModuleDslPackage.STRATEGY__CRITDECL:
        setCritdecl((CRITERION_DECL)newValue);
        return;
      case ModuleDslPackage.STRATEGY__DATASELDECL:
        setDataseldecl((DATASEL_DECL)newValue);
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
      case ModuleDslPackage.STRATEGY__CRITDECL:
        setCritdecl((CRITERION_DECL)null);
        return;
      case ModuleDslPackage.STRATEGY__DATASELDECL:
        setDataseldecl((DATASEL_DECL)null);
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
      case ModuleDslPackage.STRATEGY__CRITDECL:
        return critdecl != null;
      case ModuleDslPackage.STRATEGY__DATASELDECL:
        return dataseldecl != null;
    }
    return super.eIsSet(featureID);
  }

} //STRATEGYImpl
