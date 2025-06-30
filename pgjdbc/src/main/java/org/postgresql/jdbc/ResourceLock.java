/*
 * Copyright (c) 2004, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.jdbc;

import org.postgresql.util.PgResourceLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Extends a ReentrantLock for use in try-with-resources block.
 *
 * <h2>Example use</h2>
 * <pre>{@code
 *
 *   try (ResourceLock ignore = lock.obtain()) {
 *     // do something while holding the resource lock
 *   }
 *
 * }</pre>
 */
public final class ResourceLock extends ReentrantLock implements PgResourceLock {

  /**
   * Obtain a lock and return the ResourceLock for use in try-with-resources block.
   */
  @Override
  public ResourceLock obtain() {
    lock();
    return this;
  }

  /**
   * Unlock on exit of try-with-resources block.
   */
  @Override
  public void close() {
    this.unlock();
  }
}
