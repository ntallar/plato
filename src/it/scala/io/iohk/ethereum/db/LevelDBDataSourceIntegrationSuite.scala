package io.iohk.ethereum.db

import io.iohk.ethereum.db.dataSource.{LevelDBDataSource, LevelDbConfig}
import org.scalatest.FlatSpec

class LevelDBDataSourceIntegrationSuite extends FlatSpec with DataSourceIntegrationTestBehavior {

  private def createDataSource(path: String) = LevelDBDataSource(path, new LevelDbConfig {
    override val cacheSize: Int = 0
    override val verifyChecksums: Boolean = true
    override val paranoidChecks: Boolean = true
    override val createIfMissing: Boolean = true
  })

  it should behave like dataSource(createDataSource)
}