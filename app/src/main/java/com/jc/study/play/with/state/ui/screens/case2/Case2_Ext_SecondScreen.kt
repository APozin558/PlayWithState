package com.jc.study.play.with.state.ui.screens.case2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jc.study.play.with.state.R
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_FOOD
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_MORE
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_NOTHING
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_REST
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_SCOUT
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_SCRAP
import com.jc.study.play.with.state.ext.ExtCase2.CASE_2_TASK_WATER
import com.jc.study.play.with.state.ext.ExtLogic2.case2getNewTaskImageById
import com.jc.study.play.with.state.ext.ExtLogic2.case2getTaskIconById
import com.jc.study.play.with.state.ext.ExtLogic2.case2getTaskNameById
import com.jc.study.play.with.state.ext.ExtLogic2.case2getTaskPrefixNameById
import com.jc.study.play.with.state.models.case2.Case2CharacterData
import com.jc.study.play.with.state.ui.theme.cBoxItemColor
import com.jc.study.play.with.state.ui.theme.cPrimaryColor
import com.jc.study.play.with.state.ui.theme.cSecondaryColor
import com.jc.study.play.with.state.ui.theme.cSelectedItemBackground
import com.jc.study.play.with.state.ui.theme.cTextColor

@Composable
fun Case2uxPeopleListSection(
    gameCharactersList: MutableList<Case2CharacterData>,
    listOfSelectedItems: SnapshotStateList<Int>,
    modifier: Modifier,
){

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(2.dp)
    ){
        items( gameCharactersList) {
            item -> Case2uxPeopleListItem(
                item = item,
                isItemSelected = item.id in listOfSelectedItems,
                orderIsPressed = {
                    if (item.id in listOfSelectedItems)
                        listOfSelectedItems.remove(item.id)
                    else
                        listOfSelectedItems.add(item.id)
                }
            )
        }
    }
}

@Composable
fun Case2uxPeopleListItem(
    item: Case2CharacterData,
    isItemSelected:Boolean,
    orderIsPressed: () -> Unit
){
    var isExpanded by remember { mutableStateOf(false) }
    val listItemBackgroundColor = if (isItemSelected) cSelectedItemBackground else cBoxItemColor

    Row(
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth()
            .height(60.dp)
            .background(color = listItemBackgroundColor)
            .padding(2.dp)
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Case2uxPeopleListItemPortraitSection()
        Spacer(modifier = Modifier.width(4.dp))
        Case2uxPeopleListItemMainSection(item.name)
        Spacer(modifier = Modifier.weight(1.0f))
        Case2uxPeopleListItemTaskSection(
            currentOrder = item.currentOrderId,
            order = item.orderId,
            orderIsPressed = orderIsPressed
        )
        Case2uxPeopleListItemExpandedSection(
            isExpanded = isExpanded,
            onExpandClicked = {isExpanded = !isExpanded}
        )
    }
}

@Composable
fun Case2uxPeopleListItemExpandedSection(isExpanded: Boolean, onExpandClicked: () -> Unit) {

    val currentExpandIcon = if (isExpanded) R.drawable.ux_expand_less_icon else R.drawable.ux_expand_icon

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .width(40.dp)
            .clickable(onClick = onExpandClicked)
    ) {
        Image(painter = painterResource(id = currentExpandIcon), contentDescription = "expand" )
    }

}

@Composable
fun Case2uxPeopleListItemTaskSection(currentOrder:Int, order:Int, orderIsPressed: ()-> Unit) {
    val orderToShow = if (currentOrder != order) currentOrder else order

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .width(40.dp)
            .clickable(onClick = orderIsPressed)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp),
            contentAlignment = Alignment.TopCenter
        ){
            Text(
                text = case2getTaskPrefixNameById(taskId = orderToShow),
                fontSize = 8.sp
            )
        }
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = case2getTaskIconById(taskId = orderToShow)),
            contentDescription = "task"
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 4.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            Text(
                text = case2getTaskNameById(taskId = orderToShow),
                fontSize = 8.sp
            )
        }
    }

}

@Composable
fun Case2uxPeopleListItemMainSection(name: String) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier.padding(4.dp)
    ){
        Text(text = name , fontSize = 20.sp, fontWeight = FontWeight.Bold, color = cTextColor)
    }
}

@Composable
fun Case2uxPeopleListItemPortraitSection() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(50.dp)
        .background(color = cSecondaryColor),
    ){
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 4.dp)
                .width(36.dp)
                .height(36.dp),
            painter = painterResource(id = R.drawable.ux_char_03),
            contentDescription = "portrait"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .align(Alignment.BottomStart)
                .padding(bottom = 2.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Image(
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
                    .padding(start = 4.dp),
                painter = painterResource(id = R.drawable.ux_char_indicator_a_icon),
                contentDescription = "character indicator a"
            )
            Image(
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
                    .padding(start = 4.dp),
                painter = painterResource(id = R.drawable.ux_char_indicator_b_icon),
                contentDescription = "character indicator b"
            )
            Image(
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
                    .padding(start = 4.dp),
                painter = painterResource(id = R.drawable.ux_char_indicator_c_icon),
                contentDescription = "character indicator c"
            )
        }
    }
}

@Composable
fun Case2uxBottomSelectTaskSection(
    onNewTaskPressed: (Int) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = cPrimaryColor)
    ) {
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_NOTHING, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_REST, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_WATER, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_FOOD, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_SCRAP, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_SCOUT, onNewTaskPressed = onNewTaskPressed)
        Case2uxBottomSelectTaskSectionItem(CASE_2_TASK_MORE, onNewTaskPressed = onNewTaskPressed)
    }
}

@Composable
fun Case2uxBottomSelectTaskSectionItem(
    taskId:Int,
    onNewTaskPressed: (Int) -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp)
            .padding(start = 5.dp)
            .clickable(onClick = { onNewTaskPressed(taskId) })
    ){
        Image(painter = painterResource(id = case2getNewTaskImageById(taskId)), contentDescription = "Task $taskId" )
    }
}