/**
 */
package org.xtext.moduleDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.moduleDsl.INTERVAL;
import org.xtext.moduleDsl.Literal;
import org.xtext.moduleDsl.ModuleDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>INTERVAL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.moduleDsl.impl.INTERVALImpl#getLsqbr <em>Lsqbr</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.INTERVALImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.INTERVALImpl#getMax <em>Max</em>}</li>
 *   <li>{@link org.xtext.moduleDsl.impl.INTERVALImpl#getRsqbr <em>Rsqbr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class INTERVALImpl extends RANGEImpl implements INTERVAL
{
  /**
   * The default value of the '{@link #getLsqbr() <em>Lsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsqbr()
   * @generated
   * @ordered
   */
  protected static final String LSQBR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLsqbr() <em>Lsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsqbr()
   * @generated
   * @ordered
   */
  protected String lsqbr = LSQBR_EDEFAULT;

  /**
   * The cached value of the '{@link #getMin() <em>Min</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMin()
   * @generated
   * @ordered
   */
  protected Literal min;

  /**
   * The cached value of the '{@link #getMax() <em>Max</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMax()
   * @generated
   * @ordered
   */
  protected Literal max;

  /**
   * The default value of the '{@link #getRsqbr() <em>Rsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRsqbr()
   * @generated
   * @ordered
   */
  protected static final String RSQBR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRsqbr() <em>Rsqbr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRsqbr()
   * @generated
   * @ordered
   */
  protected String rsqbr = RSQBR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected INTERVALImpl()
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
    return ModuleDslPackage.Literals.INTERVAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLsqbr()
  {
    return lsqbr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLsqbr(String newLsqbr)
  {
    String oldLsqbr = lsqbr;
    lsqbr = newLsqbr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__LSQBR, oldLsqbr, lsqbr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal getMin()
  {
    return min;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMin(Literal newMin, NotificationChain msgs)
  {
    Literal oldMin = min;
    min = newMin;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__MIN, oldMin, newMin);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMin(Literal newMin)
  {
    if (newMin != min)
    {
      NotificationChain msgs = null;
      if (min != null)
        msgs = ((InternalEObject)min).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.INTERVAL__MIN, null, msgs);
      if (newMin != null)
        msgs = ((InternalEObject)newMin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.INTERVAL__MIN, null, msgs);
      msgs = basicSetMin(newMin, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__MIN, newMin, newMin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal getMax()
  {
    return max;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMax(Literal newMax, NotificationChain msgs)
  {
    Literal oldMax = max;
    max = newMax;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__MAX, oldMax, newMax);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMax(Literal newMax)
  {
    if (newMax != max)
    {
      NotificationChain msgs = null;
      if (max != null)
        msgs = ((InternalEObject)max).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.INTERVAL__MAX, null, msgs);
      if (newMax != null)
        msgs = ((InternalEObject)newMax).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModuleDslPackage.INTERVAL__MAX, null, msgs);
      msgs = basicSetMax(newMax, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__MAX, newMax, newMax));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRsqbr()
  {
    return rsqbr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRsqbr(String newRsqbr)
  {
    String oldRsqbr = rsqbr;
    rsqbr = newRsqbr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModuleDslPackage.INTERVAL__RSQBR, oldRsqbr, rsqbr));
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
      case ModuleDslPackage.INTERVAL__MIN:
        return basicSetMin(null, msgs);
      case ModuleDslPackage.INTERVAL__MAX:
        return basicSetMax(null, msgs);
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
      case ModuleDslPackage.INTERVAL__LSQBR:
        return getLsqbr();
      case ModuleDslPackage.INTERVAL__MIN:
        return getMin();
      case ModuleDslPackage.INTERVAL__MAX:
        return getMax();
      case ModuleDslPackage.INTERVAL__RSQBR:
        return getRsqbr();
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
      case ModuleDslPackage.INTERVAL__LSQBR:
        setLsqbr((String)newValue);
        return;
      case ModuleDslPackage.INTERVAL__MIN:
        setMin((Literal)newValue);
        return;
      case ModuleDslPackage.INTERVAL__MAX:
        setMax((Literal)newValue);
        return;
      case ModuleDslPackage.INTERVAL__RSQBR:
        setRsqbr((String)newValue);
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
      case ModuleDslPackage.INTERVAL__LSQBR:
        setLsqbr(LSQBR_EDEFAULT);
        return;
      case ModuleDslPackage.INTERVAL__MIN:
        setMin((Literal)null);
        return;
      case ModuleDslPackage.INTERVAL__MAX:
        setMax((Literal)null);
        return;
      case ModuleDslPackage.INTERVAL__RSQBR:
        setRsqbr(RSQBR_EDEFAULT);
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
      case ModuleDslPackage.INTERVAL__LSQBR:
        return LSQBR_EDEFAULT == null ? lsqbr != null : !LSQBR_EDEFAULT.equals(lsqbr);
      case ModuleDslPackage.INTERVAL__MIN:
        return min != null;
      case ModuleDslPackage.INTERVAL__MAX:
        return max != null;
      case ModuleDslPackage.INTERVAL__RSQBR:
        return RSQBR_EDEFAULT == null ? rsqbr != null : !RSQBR_EDEFAULT.equals(rsqbr);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (lsqbr: ");
    result.append(lsqbr);
    result.append(", rsqbr: ");
    result.append(rsqbr);
    result.append(')');
    return result.toString();
  }

} //INTERVALImpl
