/*
 * Copyright (c) 2025, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */
package org.postgresql.util;

import org.postgresql.jdbc.ResourceLock;

public final class ResourceLockFactory {

  public static final String RESOURCE_LOCK_CONTROL_PROPERTYNAME = "org.postgresql.connectionUseScopedToThreads";
  private static final boolean TRUST_CONNECTION_SCOPING = Boolean.getBoolean(RESOURCE_LOCK_CONTROL_PROPERTYNAME);

  /**
   * Returns a PgResourceLock implementation which depends on the JVM property {@code org.postgresql.connectionUseScopedToThreads}:
   * if this property is set to {@code true} then resources which are normally scoped to a connection will not be protected
   * by concurrency locks.
   * Setting this property should be reserved to situation in which you are absolutely sure that these
   * locks are both unnecessary and a proven overhead on your system.
   */
  public static PgResourceLock makePossiblyConfinedLock() {
    if ( TRUST_CONNECTION_SCOPING ) {
      return NoOpPgResourceLock.INSTANCE;
    }
    else {
      return new ResourceLock();
    }
  }
}
