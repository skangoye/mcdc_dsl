/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.moduleDsl.DATASEL;
import org.xtext.moduleDsl.DATASEL_DECL;
import org.xtext.moduleDsl.ModuleDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DATASEL DECL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.DATASEL_DECLImpl#getData1 <em>Data1</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.DATASEL_DECLImpl#getData2 <em>Data2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DATASEL_DECLImpl extends MinimalEObjectImpl.Container implements DATASEL_DECL
{
  /**
   * The cached value of the '{@link #getData1() <em>Data1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getData1()
   * @generated
   * @ordered
   */
  protected DATASEL data1;

  /**
   * The cached value of the '{@link #getData2() <em>Data2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getData2()
   * @generated
   * @ordered
   */
  protected DATASEL data2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DATASEL_DECLImpl()
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
    return ModuleDslPackage.Literals.DATASEL_DECL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DATASEL getData1()
  {
    return data1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetData1(DATASEL newData1, NotificationChain msgs)
  {
    DATASEL oldData1 = data1;
    data1 = newData1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.DATASEL_DECL__DATA1, oldData1, newData1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setData1(DATASEL newData1)
  {
    if (newData1 != data1)
    {
      NotificationChain msgs = null;
      if (data1 != null)
        msgs = ((InternalEObject)data1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.DATASEL_DECL__DATA1, null, msgs);
      if (newData1 != null)
        msgs = ((InternalEObject)newData1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.DATASEL_DECL__DATA1, null, msgs);
      msgs = basicSetData1(newData1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.DATASEL_DECL__DATA1, newData1, newData1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DATASEL getData2()
  {
    return data2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetData2(DATASEL newData2, NotificationChain msgs)
  {
    DATASEL oldData2 = data2;
    data2 = newData2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.DATASEL_DECL__DATA2, oldData2, newData2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setData2(DATASEL newData2)
  {
    if (newData2 != data2)
    {
      NotificationChain msgs = null;
      if (data2 != null)
        msgs = ((InternalEObject)data2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.DATASEL_DECL__DATA2, null, msgs);
      if (newData2 != null)
        msgs = ((InternalEObject)newData2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.DATASEL_DECL__DATA2, null, msgs);
      msgs = basicSetData2(newData2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.DATASEL_DECL__DATA2, newData2, newData2));
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
      case ModuleDslPackage.DATASEL_DECL__DATA1:
        return basicSetData1(null, msgs);
      case ModuleDslPackage.DATASEL_DECL__DATA2:
        return basicSetData2(null, msgs);
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
      case ModuleDslPackage.DATASEL_DECL__DATA1:
        return getData1();
      case ModuleDslPackage.DATASEL_DECL__DATA2:
        return getData2();
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
      case ModuleDslPackage.DATASEL_DECL__DATA1:
        setData1((DATASEL)newValue);
        return;
      case ModuleDslPackage.DATASEL_DECL__DATA2:
        setData2((DATASEL)newValue);
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
      case ModuleDslPackage.DATASEL_DECL__DATA1:
        setData1((DATASEL)null);
        return;
      case ModuleDslPackage.DATASEL_DECL__DATA2:
        setData2((DATASEL)null);
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
      case ModuleDslPackage.DATASEL_DECL__DATA1:
        return data1 != null;
      case ModuleDslPackage.DATASEL_DECL__DATA2:
        return data2 != null;
    }
    return super.eIsSet(featureID);
  }

} //DATASEL_DECLImpl
