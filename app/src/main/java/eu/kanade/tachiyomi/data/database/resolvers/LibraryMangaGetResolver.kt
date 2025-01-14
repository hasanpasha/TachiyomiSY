package eu.kanade.tachiyomi.data.database.resolvers

import android.database.Cursor
import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver
import eu.kanade.tachiyomi.data.database.mappers.BaseMangaGetResolver
import eu.kanade.tachiyomi.data.database.models.LibraryManga
import eu.kanade.tachiyomi.data.database.tables.MangaTable

class LibraryMangaGetResolver : DefaultGetResolver<LibraryManga>(), BaseMangaGetResolver {

    companion object {
        val INSTANCE = LibraryMangaGetResolver()
    }

    override fun mapFromCursor(cursor: Cursor): LibraryManga {
        val manga = LibraryManga()

        mapBaseFromCursor(manga, cursor)
        manga.unread = cursor.getInt(cursor.getColumnIndexOrThrow(MangaTable.COL_UNREAD))
        manga.category = cursor.getInt(cursor.getColumnIndexOrThrow(MangaTable.COL_CATEGORY))
        // SY -->
        manga.read = cursor.getInt(cursor.getColumnIndexOrThrow(MangaTable.COL_READ))
        // SY <--

        return manga
    }
}
