/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.moduleDsl.AbstractVAR_DECL;
import org.xtext.moduleDsl.ModuleDslPackage;
import org.xtext.moduleDsl.VarExpRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Exp Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.VarExpRefImpl#getVref <em>Vref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarExpRefImpl extends EXPRESSIONImpl implements VarExpRef
{
  /**
   * The cached value of the '{@link #getVref() <em>Vref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVref()
   * @generated
   * @ordered
   */
  protected AbstractVAR_DECL vref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VarExpRefImpl()
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
    return ModuleDslPackage.Literals.VAR_EXP_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVAR_DECL getVref()
  {
    if (vref != null && vref.eIsProxy())
    {
      InternalEObject oldVref = (InternalEObject)vref;
      vref = (AbstractVAR_DECL)eResolveProxy(oldVref);
      if (vref != oldVref)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModuleDslPackage.VAR_EXP_REF__VREF, oldVref, vref));
      }
    }
    return vref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVAR_DECL basicGetVref()
  {
    return vref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVref(AbstractVAR_DECL newVref)
  {
    AbstractVAR_DECL oldVref = vref;
    vref = newVref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.VAR_EXP_REF__VREF, oldVref, vref));
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
      case ModuleDslPackage.VAR_EXP_REF__VREF:
        if (resolve) return getVref();
        return basicGetVref();
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
      case ModuleDslPackage.VAR_EXP_REF__VREF:
        setVref((AbstractVAR_DECL)newValue);
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
      case ModuleDslPackage.VAR_EXP_REF__VREF:
        setVref((AbstractVAR_DECL)null);
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
      case ModuleDslPackage.VAR_EXP_REF__VREF:
        return vref != null;
    }
    return super.eIsSet(featureID);
  }

} //VarExpRefImpl
