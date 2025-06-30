package org.postgresql.util;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.locks.Condition;

final class NoOpPgResourceLock implements PgResourceLock {

  static final NoOpPgResourceLock INSTANCE = new NoOpPgResourceLock();

  private NoOpPgResourceLock() {}

  @Override
  public PgResourceLock obtain() {
    return this;
  }

  @Override
  public void close() {
    //no-op
  }

  @Override
  public @Nullable Condition newCondition() {
    return null;
  }

}
