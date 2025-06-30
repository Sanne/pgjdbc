/*
 * Copyright (c) 2025, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */
package org.postgresql.util;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.locks.Condition;

public interface PgResourceLock extends AutoCloseable {

  PgResourceLock obtain();

  /**
   * To release the lock in a convenient auto-closeable block
   */
  @Override
  void close();

  @Nullable Condition newCondition();
}
